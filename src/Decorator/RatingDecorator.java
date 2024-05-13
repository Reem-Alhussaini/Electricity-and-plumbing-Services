package Decorator;

// Decorator
public abstract class RatingDecorator implements ServiceProvider {
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










