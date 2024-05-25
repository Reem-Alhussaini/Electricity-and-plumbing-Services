package builder;

import proxy.ServiceAvailability;

// Director
public class InvoiceEngineer {
    private Builder builder;
    private String name;
    private String ServiceProviderName;
    private String service;
    private ServiceAvailability proxy;

    public InvoiceEngineer(Builder builder, String name,String ServiceProviderName, String service, ServiceAvailability proxy) {
        this.name = name;
        this.ServiceProviderName = ServiceProviderName;
        this.service = service;
        this.proxy = proxy;
        this.builder = builder;
    }

    public Invoice getInvoice() {
        return builder.build();
    }

    public void makeInvoice(){
        builder.buildName(name);
        builder.buildServiceProviderName(ServiceProviderName);
        builder.buildService(service);
        builder.buildDate();
        builder.buildPrice(proxy, ServiceProviderName);
    }
}
