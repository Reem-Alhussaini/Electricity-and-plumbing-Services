package builder;

import java.util.Date;

// Invoice class representing the invoice
public class Invoice {
    private String name;
    private String serviceProviderName;
    private String service;
    private Date date;
    private String price;

    // Private constructor to prevent direct instantiation
    Invoice(InvoiceBuilder builder) {
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

    @Override
    public String toString() {
        return "Invoice{" +
                "name='" + name + '\'' +
                ", serviceProviderName='" + serviceProviderName + '\'' +
                ", service='" + service + '\'' +
                ", date=" + date +
                ", price='" + price + '\'' +
                '}';
    }
}

