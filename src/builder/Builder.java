package builder;


import java.util.Date;

// Builder interface
public interface Builder {
    Builder setName(String name);
    Builder setServiceProviderName(String serviceProviderName);
    Builder setService(String service);
    Builder setDate(Date date);
    Builder setPrice(int price);
    Invoice build();
}

