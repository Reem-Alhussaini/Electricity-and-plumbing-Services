package builder;


import proxy.ServiceAvailability;

import java.util.Date;
// InvoiceBuilder class to construct Invoice objects
public class InvoiceBuilder implements Builder {
    private Invoice invoice;


    public InvoiceBuilder() {
        this.invoice = new Invoice();
    }

    // Setters for invoice attributes
    @Override
    public void buildName(String name) {
        invoice.setName(name);
    }

    @Override
    public void buildServiceProviderName(String ServiceProviderName) {
        invoice.setServiceProviderName(ServiceProviderName);
    }

    @Override
    public void buildService(String service) {
        invoice.setService(service);
    }

    @Override
    public void buildDate() {
        invoice.setDate(new Date());
    }

    @Override
    public void buildPrice(ServiceAvailability proxy, String ServiceProviderName) {
        int price = proxy.getPrice(ServiceProviderName);
        invoice.setPrice(price);
    }

    // Method to build the Invoice object
    @Override
    public Invoice build() {
        return this.invoice;
    }
}