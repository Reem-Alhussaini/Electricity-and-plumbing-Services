package Strategy;
// Concrete strategy for rating employees
class FiveStarRatingStrategy implements RatingStrategy {
    @Override
    public void rateEmployee(Employee employee, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating should be between 1 and 5.");
        }
        employee.setRating(rating);
        System.out.println("Rated " + employee.getName() + " with " + rating + " stars.");
    }
}