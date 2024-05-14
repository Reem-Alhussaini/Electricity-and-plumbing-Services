package builder;


import java.util.Date;
// InvoiceBuilder class to construct Invoice objects
public class InvoiceBuilder implements Builder {
    private Invoice invoice;


    public InvoiceBuilder() {
        this.invoice = new Invoice();
    }

    // Setters for invoice attributes
    @Override
    public void buildName() {
        invoice.setName("Customer Name");
    }

    @Override
    public void buildServiceProviderName() {
        invoice.setServiceProviderName("Service Provider Name");
    }

    @Override
    public void buildService() {
        invoice.setService("Service Name");
    }

    @Override
    public void buildDate() {
        invoice.setDate(new Date());
    }

    @Override
    public void buildPrice() {
        invoice.setPrice(100); // Example price
    }

    // Method to build the Invoice object
    @Override
    public Invoice build() {
        return this.invoice;
    }
}