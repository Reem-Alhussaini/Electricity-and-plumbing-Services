package proxy;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        //create scanner to read type
        Scanner sc = new Scanner(System.in);

        System.out.println("insert service type: ");
        String serviceType = sc.next();

        // Create a service availability proxy
        ServiceAvailability proxy = new DataBaseProxy(serviceType);


        // Check service availability
        String isElectricalServiceAvailable = proxy.isElectricianAvailable();
        String isPlumbingServiceAvailable = proxy.isPlumberAvailable();



        // Display service availability
        System.out.println("Electrician " + "(electrician name from DB):" + isElectricalServiceAvailable);
        System.out.println("Plumber " + "(plumber name from DB):" + isPlumbingServiceAvailable);
    }
}