package Factory;

// Factory class for creating appointments
public class AppointmentFactory {
    public Appointment createAppointment(String type) {
        if (type.equalsIgnoreCase("electrician")) {
            return new ElectricalAppointment();
        } else if (type.equalsIgnoreCase("plumber")) {
            return new PlumbingAppointment();
        } else {
            throw new IllegalArgumentException("Invalid appointment type: " + type);
        }
    }
}
