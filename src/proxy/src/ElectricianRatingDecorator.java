
// Concrete Decorator for Electrician rating functionality
public class ElectricianRatingDecorator extends RatingDecorator {
    public ElectricianRatingDecorator(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    public void updateRating(int newRating) {
        ((Electrician) serviceProvider).updateRating(newRating);
    }
}

