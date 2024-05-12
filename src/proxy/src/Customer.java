import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        //create scanner to read type
        Scanner sc = new Scanner(System.in);


        // Create a service availability proxy
        ServiceAvailability proxy = new DataBaseProxy();


        // Check service availability
        boolean isElectricalServiceAvailable = proxy.isServiceAvailable("Electrical");
        boolean isPlumbingServiceAvailable = proxy.isServiceAvailable("Plumbing");



        // Display service availability
        System.out.println("Electrician " + "(electrician name from DB):" + isElectricalServiceAvailable);
        System.out.println("Plumber " + "(plumber name from DB):" + isPlumbingServiceAvailable);
    }
}