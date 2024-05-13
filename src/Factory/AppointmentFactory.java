package Factory;

import proxy.*;

import java.util.Date;

public class AppointmentFactory {

   

    public Appointment createAppointment(ServiceAvailability proxy, String serviceType, String customerName, String ServiceProviderName) {
        if (serviceType.equalsIgnoreCase("electrician")) {
//            proxy.changeState(name);
//            Date date = new Date(); // Current date
//            int price = proxy.getPrice();

            //the object must contain appointment info as attributes
            return new ElectricalAppointment();


        } else if (serviceType.equalsIgnoreCase("plumber")) {
//            proxy.changeState(name);
            //the object must contain appointment info as attributes
            return new PlumbingAppointment();

        } else {
            throw new IllegalArgumentException("Invalid appointment type or no available appointments.");
        }
    }
}