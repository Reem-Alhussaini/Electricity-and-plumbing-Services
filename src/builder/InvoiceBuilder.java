package builder;


import java.util.Date;
// InvoiceBuilder class to construct Invoice objects
public class InvoiceBuilder implements Builder {
    private Invoice invoice;

    public InvoiceBuilder(Invoice invoice) {
        this.invoice = new Invoice();
    }

    // Setters for invoice attributes
    @Override
    public String buildName() {
        return invoice; //invoice.setName(customer)
    }

    @Override
    public Builder setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
        return this;
    }

    @Override
    public Builder setService(String service) {
        this.service = service;
        return this;
    }

    @Override
    public Builder setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public Builder setPrice(int price) {
        this.price = price;
        return this;
    }

    // Method to build the Invoice object
    @Override
    public Invoice build() {
        return new Invoice(this);
    }
}
