package Decorator;

import proxy.ServiceAvailability;

// Concrete Decorator for Electrician storing rating in database functionality
public class ElectricianRatingDecorator extends RatingDecorator {
    public ElectricianRatingDecorator(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    @Override
    public float rate(String serviceProviderName, ServiceAvailability proxy) {
        float rating = super.rate(serviceProviderName, proxy);
        System.out.println("Rating for Electrician " + serviceProviderName + " is: " + rating);
        System.out.println("Storing rating in the database...");
        System.out.println(proxy.changeRating(serviceProviderName, rating));

        return rating;
    }
}


