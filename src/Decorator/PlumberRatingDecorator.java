package Decorator;

// Concrete Decorator for Plumber rating functionality
class PlumberRatingDecorator extends RatingDecorator {
    public PlumberRatingDecorator(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    public void updateRating(int newRating) {
        ((Plumber) serviceProvider).updateRating(newRating);
    }
}