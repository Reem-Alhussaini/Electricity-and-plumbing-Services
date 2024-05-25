package Factory;

import proxy.*;


public class AppointmentFactory {

    public Appointment createAppointment(String serviceType) {
        ServiceAvailability proxy = new DataBaseProxy(serviceType);

        if (serviceType.equalsIgnoreCase("electrician")) {
            return new ElectricalAppointment(proxy);

        } else if (serviceType.equalsIgnoreCase("plumber")) {
            return new PlumbingAppointment(proxy);
        }
        return null;
    }
}