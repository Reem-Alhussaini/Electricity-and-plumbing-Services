package builder.builder;

import java.util.Date;

// Invoice class representing the invoice
public class Invoice {
    private String name;
    private String serviceProviderName;
    private String service;
    private Date date;
    private String price;

    // Private constructor to prevent direct instantiation
    private Invoice(InvoiceBuilder builder) {
        this.name = builder.name;
        this.serviceProviderName = builder.serviceProviderName;
        this.service = builder.service;
        this.date = builder.date;
        this.price = builder.price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public String getService() {
        return service;
    }

    public Date getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    // InvoiceBuilder class to construct Invoice objects
    public static class InvoiceBuilder {
        private String name;
        private String serviceProviderName;
        private String service;
        private Date date;
        private String price;

        // Setters for invoice attributes
        public InvoiceBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public InvoiceBuilder setServiceProviderName(String serviceProviderName) {
            this.serviceProviderName = serviceProviderName;
            return this;
        }

        public InvoiceBuilder setService(String service) {
            this.service = service;
            return this;
        }

        public InvoiceBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public InvoiceBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        // Method to build the Invoice object
        public Invoice build() {
            return new Invoice(this);
        }
    }
}
