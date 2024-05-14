package Decorator;

import proxy.ServiceAvailability;
import java.util.Scanner;

// Concrete Component representing Plumber
public class Plumber implements ServiceProvider {
    private float rating;

    public Plumber(String name) {
        this.rating = 0; // Initial rating
    }

    @Override
    public float rate(String serviceProviderName, ServiceAvailability proxy) {
        Scanner input = new Scanner(System.in);
        System.out.print("How was the service? Please rate your service provider from 1-5: ");
        float newRating = input.nextFloat();
        this.rating = (this.rating + newRating) / 2.0f;
        return this.rating;
    }
}

