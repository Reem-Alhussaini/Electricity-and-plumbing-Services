package builder;


import java.util.Date;
// InvoiceBuilder class to construct Invoice objects
public class InvoiceBuilder implements Builder {
    String name;
    String serviceProviderName;
    String service;
    Date date;
    String price;



    // Setters for invoice attributes
    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
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
    public Builder setPrice(String price) {
        this.price = price;
        return this;
    }

    // Method to build the Invoice object
    @Override
    public Invoice build() {
        return new Invoice(this);
    }
}
