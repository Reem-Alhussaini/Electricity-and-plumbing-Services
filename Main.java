
package builder.builder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Sample data from the database
        String name = "Name";
        String serviceProviderName = "serviceProvider";
        String service = "Service";
        Date date = new Date(); // Current date
        String price = "price"; 

        // Create an invoice
        Invoice invoice = new Invoice.InvoiceBuilder()
                .setName(name)
                .setServiceProviderName(serviceProviderName)
                .setService(service)
                .setDate(date)
                .setPrice(price)
                .build();

        // Print the invoice details
        System.out.println(invoice);
    }
}