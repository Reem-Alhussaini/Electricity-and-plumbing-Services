package Decorator;

import proxy.ServiceAvailability;

// Decorator
public abstract class RatingDecorator implements ServiceProvider {
    protected ServiceProvider serviceProvider;

    public RatingDecorator(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public float rate(String serviceProviderName, ServiceAvailability proxy) {
        return serviceProvider.rate(serviceProviderName, proxy);
    }
}











