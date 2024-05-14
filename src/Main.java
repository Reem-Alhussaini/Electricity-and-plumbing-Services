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

        //database (Proxy)
        //RealDataBase.start();
        System.out.println();

        //log in (Strategy)
        String customer = login();
        System.out.println();

        //choose service type
        String service = chooseServiceType();
        System.out.println();

        //create appointment (Factory)
        AppointmentFactory appointmentFactory = new AppointmentFactory();
        Appointment app = appointmentFactory.createAppointment(service) ;
        String serviceProviderName = app.schedule();
        System.out.println();

        //***** we need to get the invoice data from the appointment object, modify createAppointment method first******//
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

        // Call the rate method on the decorator
        //float rating = decoratedService.rate(service, proxy);

    }

//        if(service.equalsIgnoreCase("plumber")){
//            Plumber plumber = new Plumber(serviceProviderName);
//            // Wrapping plumber with rating functionality
//            PlumberRatingDecorator ratedPlumber = new PlumberRatingDecorator(plumber);
//            //updating plumber rating
//            ratedPlumber.updateRating(rating);
//            System.out.println("Plumber rating: " + ratedPlumber.rate());
//        }else{
//            Electrician electrician = new Electrician(serviceProviderName);
//            // Wrapping electrician with rating functionality
//            ElectricianRatingDecorator ratedElectrician = new ElectricianRatingDecorator(electrician);
//            //updating electrician rating
//            ratedElectrician.updateRating(rating);
//            System.out.println("Electrician rating: " + ratedElectrician.rate());
//        }



//        //Factory >> Appointment
//        String serviceType="";
//        String name="";
//        AppointmentFactory factory = new AppointmentFactory();
//        Appointment appointment = factory.createAppointment(serviceType, name);
//        appointment.schedule();

    //----------------------------------------------------------------------------------------------------------------
    //login (Strategy)
    public static String login() throws SQLException {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Choose login method:");
        System.out.println("1. Email");
        System.out.println("2. Username");

        // Get user's choice
        int choice = userInput.nextInt();
        userInput.nextLine(); // Consume newline character

        // Create corresponding LoginStrategy based on user's choice
        LoginStrategy loginStrategy;
        if (choice == 1) {
            loginStrategy = new EmailLoginStrategy();
        } else if (choice == 2) {
            loginStrategy = new UsernameLoginStrategy();
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            return login();
        }

        // Create LoginContext with the selected strategy
        LoginContext loginContext = new LoginContext(loginStrategy);

        // Call performLogin() method on the LoginContext
        String loggedInUser = loginContext.performLogin();
        System.out.println("Logged in as: " + loggedInUser);
        return loggedInUser;
    }

//    public static String login() throws SQLException {
//        Scanner userInput = new Scanner(System.in);
//        System.out.print("Enter username: ");
//        String name = userInput.nextLine();
//        System.out.print("Enter password: ");
//        String password = userInput.nextLine();
//
//
//        try (Connection connection = getConnection(DB_URL, USERNAME, PASSWORD); PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_info WHERE name = ? AND password = ?")) {
//            stmt.setString(1, name);
//            stmt.setString(2, password);
//            try (ResultSet result = stmt.executeQuery()) {
//                if (result.next()) {
//                    System.out.println("Login successful!");
//                    return name; // Return the username if login is successful
//                } else {
//                    System.out.println("Invalid name or password. Please try again.");
//                    return login(); // Recursive call to allow the user to try again
//                }
//            }
//        }
//    }
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


}