package Factory;

import proxy.*;

import java.util.Date;

public class AppointmentFactory {

    public Appointment createAppointment(String serviceType) {
        ServiceAvailability proxy = new DataBaseProxy(serviceType);

        if (serviceType.equalsIgnoreCase("electrician")) {
            //the object must contain appointment info as attributes
            return new ElectricalAppointment(proxy);

        } else if (serviceType.equalsIgnoreCase("plumber")) {
            //the object must contain appointment info as attributes
            return new PlumbingAppointment(proxy);
        }
        return null;
    }
}