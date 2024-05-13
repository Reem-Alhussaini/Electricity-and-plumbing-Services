import Decorator.Electrician;
import Decorator.ElectricianRatingDecorator;

import Factory.Appointment;
import Factory.AppointmentFactory;
import builder.Invoice;
import builder.InvoiceBuilder;
import proxy.DataBaseProxy;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;


public class Main {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "1234";
    public static void main(String[] args) throws SQLException {

        //log in
        String customerName = login();

        //choose service type
        String service = chooseServiceType();

        //------------------------------------------------------------------------------------

        DataBaseProxy proxy = new DataBaseProxy(service);

        // Check availability
        String serviceProviderName;
        if(service.equalsIgnoreCase("plumber")) {
            serviceProviderName = proxy.isPlumberAvailable();
        }else{
            serviceProviderName = proxy.isElectricianAvailable();
        }

        //create appointment
        AppointmentFactory appointment = new AppointmentFactory();
        appointment.createAppointment(proxy, service,customerName, serviceProviderName) ;

        //***** we need to get the invoice data from the appointment object, modify createAppointment method first******//
        //create invoice
        java.util.Date date = new Date(); // Current date
        int price = proxy.getPrice(serviceProviderName);
        Invoice invoice = new InvoiceBuilder()
                .setName(customerName) //customer name
                .setServiceProviderName(serviceProviderName) //technician name
                .setService(service)
                .setDate(date)
                .setPrice(price)
                .build();

        System.out.println(invoice.toString());

//--------------------------------------------------------------------------------------------------------------------------------
        // Creating electrician
//        Electrician electrician = new Electrician("John Doe", "123456789");
//
//        // Wrapping electrician with rating functionality
//        ElectricianRatingDecorator ratedElectrician = new ElectricianRatingDecorator(electrician);
//
//        // Simulating a rating event
//        ratedElectrician.updateRating(4);
//
//        // Getting updated rating
//        System.out.println("Electrician rating: " + ratedElectrician.getRating());
//
//
//        //Factory >> Appointment
//        String serviceType="";
//        String name="";
//        AppointmentFactory factory = new AppointmentFactory();
//        Appointment appointment = factory.createAppointment(serviceType, name);
//        appointment.schedule();
    }
    //----------------------------------------------------------------------------------------------------------------

    public static String login() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = userInput.nextLine();
        System.out.print("Enter password: ");
        String password = userInput.nextLine();
        userInput.close();

        try (Connection connection = getConnection(DB_URL, USERNAME, PASSWORD); PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_info WHERE name = ? AND password = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    System.out.println("Login successful!");
                    return name; // Return the username if login is successful
                } else {
                    System.out.println("Invalid name or password. Please try again.");
                    return login(); // Recursive call to allow the user to try again
                }
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------------
    public static String chooseServiceType() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a service type:");
        System.out.println("1. Electrical");
        System.out.println("2. Plumber");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = userInput.nextInt();

        String serviceType;
        if (choice == 1) {
            serviceType = "Electrical";
        } else if (choice == 2) {
            serviceType = "Plumber";
        } else {
            System.out.println("Invalid choice. Please try again.");
            serviceType = chooseServiceType(); // Recursive call to allow the user to choose again
        }

        userInput.close();
        return serviceType;
    }
}