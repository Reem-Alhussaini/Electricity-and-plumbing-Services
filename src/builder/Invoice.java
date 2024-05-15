package builder;

import proxy.ServiceAvailability;

import java.util.Date;

//creates invoice builder
// Invoice class representing the invoice
public class Invoice {
    private String name;
    private String serviceProviderName;
    private String service;
    private Date date;
    private int price;

    // Private constructor to prevent direct instantiation
    Invoice() {

        //String name, String serviceProvidername, String service, ServiceAvailability proxy, Date date <- this was parameters

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

    public int getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(int price) {
        this.price = price;
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