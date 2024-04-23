package Decorator;

// Decorator interface for rating functionality
abstract class RatingDecorator implements ServiceProvider {
    protected ServiceProvider serviceProvider;

    public RatingDecorator(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String getName() {
        return serviceProvider.getName();
    }

    @Override
    public String getPhoneNumber() {
        return serviceProvider.getPhoneNumber();
    }

    @Override
    public float getRating() {
        return serviceProvider.getRating();
    }
}

// Concrete Decorator for Electrician rating functionality
class ElectricianRatingDecorator extends RatingDecorator {
    public ElectricianRatingDecorator(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    public void updateRating(int newRating) {
        ((Electrician) serviceProvider).updateRating(newRating);
    }
}
