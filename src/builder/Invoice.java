package builder;

import java.util.Date;

// Invoice class representing the invoice
//creates invoice builder
public class Invoice {
    private String name;
    private String serviceProviderName;
    private String service;
    private Date date;
    private int price;

    // Private constructor to prevent direct instantiation
    Invoice() {}

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

    public int getPrice() {
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

