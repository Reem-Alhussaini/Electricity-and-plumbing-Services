import Decorator.*;
import Factory.*;
import Strategy.*;
import builder.*;
import proxy.*;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

//import static java.sql.DriverManager.getConnection;


public class Main {
//    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
//    private static final String USERNAME = "root";
//    //change the password to your password
//    private static final String PASSWORD = "Ar@121963";
    public static void main(String[] args) throws SQLException{

        //create the database (Proxy)
        RealDataBase.start();
        System.out.println();

        //prompt the user to choose a login strategy and perform login operation (Strategy)
        String customer = login();
        System.out.println("Logged in user: " + customer);
        System.out.println();

        //prompt the user to choose a service type (plumber or electrician)
        String service = chooseServiceType();
        System.out.println();

        //create appointment (Factory)
        AppointmentFactory appointmentFactory = new AppointmentFactory();
        Appointment app = appointmentFactory.createAppointment(service) ;
        String serviceProviderName = app.schedule();

        if(serviceProviderName.equalsIgnoreCase("no electrician available") ||
                serviceProviderName.equalsIgnoreCase("no plumber available")){
            System.out.println(serviceProviderName);
            System.exit(0);
        }
        System.out.println();

        //------------------------------------------------------------------------------------
        //create invoice (Builder)
        ServiceAvailability proxy = new DataBaseProxy(service);
        Date date = new Date(); // appointment date
        int price = proxy.getPrice(serviceProviderName); //service price

        Invoice invoice = new InvoiceBuilder()
                .setName(customer) //customer name
                .setServiceProviderName(serviceProviderName) //technician name
                .setService(service)
                .setDate(date)
                .setPrice(price)
                .build();

        //this method must be in a database proxy class
        RealDataBase.insertInvoices(customer,serviceProviderName,service, date ,price);
        System.out.println(invoice.toString());
        System.out.println();
        //insert invoice in database

        //--------------------------------------------------------------------------------------------------------------------------------
        //Rating (Decorator)
        rate(service, serviceProviderName);
    }
    //----------------------------------------------------------------------------------------------------------------
    //login (Strategy)
    public static String login() {
        Scanner scanner = new Scanner(System.in);
        LoginContext loginContext = new LoginContext();

        // Prompt user to choose login strategy
        System.out.println("Choose login method:");
        System.out.println("1. Username");
        System.out.println("2. Email");
        int choice = scanner.nextInt();

        // Set the selected strategy
        switch (choice) {
            case 1:
                loginContext.setLoginStrategy(new UsernameLoginStrategy());
                break;
            case 2:
                loginContext.setLoginStrategy(new EmailLoginStrategy());
                break;
            default:
                return "Invalid choice.";
        }

        try {
            // Perform login using the selected strategy
            return loginContext.performLogin();
        } catch (SQLException e) {
            return "Error during login: " + e.getMessage();
        }
    }
    //----------------------------------------------------------------------------------------------------------------
    public static String chooseServiceType() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a service type:");
        System.out.println("1. Electrician");
        System.out.println("2. Plumber");
        System.out.print("Enter your choice (1 or 2): ");


        //String input = userInput.next();
        int choice = userInput.nextInt();
        String serviceType;
        if (choice == 1) {
            serviceType = "electrician";
        } else if (choice == 2) {
            serviceType = "plumber";
        } else {
            System.out.println("Invalid choice. Please try again.");
            serviceType = chooseServiceType(); // Recursive call to allow the user to choose again
        }

        return serviceType;
    }
    //----------------------------------------------------------------------------------------------------------------
    public static void rate(String service, String serviceProviderName){

        ServiceProvider serviceProvider;
        if (service.equalsIgnoreCase("plumber")) {
            serviceProvider = new Plumber(serviceProviderName);
        } else if (service.equals("electrician")) {
            serviceProvider = new Electrician(serviceProviderName);
        } else {
            throw new IllegalArgumentException("Invalid service type");
        }

        // Create instances of decorators, passing concrete components as arguments
        ServiceProvider decoratedService;
        if (service.equals("plumber")) {
            decoratedService = new PlumberRatingDecorator(serviceProvider);
        } else if (service.equals("electrician")) {
            decoratedService = new ElectricianRatingDecorator(serviceProvider);
        } else {
            throw new IllegalArgumentException("Invalid service type");
        }
    }

}