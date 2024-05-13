package proxy;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        //RealDataBase.start();
        //create scanner to read type
        Scanner sc = new Scanner(System.in);

        System.out.println("insert service type: ");
        String serviceType = sc.next();


        System.out.println("insert a name: ");
        String name = sc.next();
        // Create a service availability proxy
        ServiceAvailability proxy = new DataBaseProxy(serviceType, name);


        // Check service availability
        if (serviceType.equals("Plumber")){
            boolean isPlumbingServiceAvailable = proxy.isPlumberAvailable(serviceType);
            System.out.println("Plumber " + name + isPlumbingServiceAvailable);
        } else if (serviceType.equals("Electrician")) {
            boolean isElectricalServiceAvailable = proxy.isElectricianAvailable(serviceType);
            System.out.println("Electrician " + "(electrician name from DB):" + isElectricalServiceAvailable);
        }

    }
}