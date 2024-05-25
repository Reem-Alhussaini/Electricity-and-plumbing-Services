package builder;

import proxy.ServiceAvailability;

// Builder interface
public interface Builder {
        void buildName(String name);

        void buildServiceProviderName(String ServiceProviderName);

        void buildService(String service);

        void buildDate();

        void buildPrice(ServiceAvailability proxy, String ServiceProviderName);

        Invoice build();
    }


