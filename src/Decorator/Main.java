package Decorator;

public class Main {
    public static void main(String[] args) {
        // Creating electrician
        Electrician electrician = new Electrician("John Doe", "123456789");

        // Wrapping electrician with rating functionality
        ElectricianRatingDecorator ratedElectrician = new ElectricianRatingDecorator(electrician);

        // Simulating a rating event
        ratedElectrician.updateRating(4);

        // Getting updated rating
        System.out.println("Electrician rating: " + ratedElectrician.getRating());
    }
}
