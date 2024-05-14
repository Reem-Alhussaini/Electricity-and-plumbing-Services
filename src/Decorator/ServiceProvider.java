package Decorator;

import proxy.ServiceAvailability;

// Component interface
public interface ServiceProvider {
    float rate(String serviceProviderName, ServiceAvailability proxy);
}

