

public class Plumber implements ServiceProvider {
    private String name;
    private String phoneNumber;
    private float rating;

    public Plumber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rating = 0; // Initial rating
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public float getRating() {
        return rating;
    }

    public void updateRating(int newRating) {
        // Update rating logic based on new rating
        // For simplicity, let's just take the average of old and new ratings
        this.rating = (this.rating + newRating) / 2.0f;
    }
}