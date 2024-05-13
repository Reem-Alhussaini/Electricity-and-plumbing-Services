
package builder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Sample data from the database
        String name = "Name";
        String serviceProviderName = "serviceProvider";
        String service = "Service";
        Date date = new Date(); // Current date
        int price = "price";

        // Create an invoice
        Invoice invoice = new InvoiceBuilder()
                .setName(name) //customer name
                .setServiceProviderName(serviceProviderName) //technician name
                .setService(service)
                .setDate(date)
                .setPrice(price)
                .build();

        // Print the invoice details
        System.out.println(invoice);
    }
}