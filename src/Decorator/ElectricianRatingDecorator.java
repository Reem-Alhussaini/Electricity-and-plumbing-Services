package Decorator;

import proxy.ServiceAvailability;

// Concrete Decorator for Electrician rating functionality
public class ElectricianRatingDecorator extends RatingDecorator {
    public ElectricianRatingDecorator(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    @Override
    public float rate(String serviceProviderName, ServiceAvailability proxy) {
        // Call the rate method of the wrapped component
        float rating = super.rate(serviceProviderName, proxy);

        // Add additional functionality (if any) before or after calling the wrapped component's method

        // For example, you could store the rating in the database
        System.out.println("Rating for Electrician " + serviceProviderName + " is: " + rating);
        System.out.println("Storing rating in the database...");
        System.out.println(proxy.changeRating(serviceProviderName, rating));

        return rating;
    }
}


