package Factory;

import proxy.*;

public class AppointmentFactory {
   
    String name;

    // Create a proxy instance
    DataBaseProxy proxy = new DataBaseProxy("Plumber");

    // Check availability
    boolean isPlumberAvailable = proxy.isPlumberAvailable(name);
    boolean isElectricianAvailable = proxy.isElectricianAvailable(name);    

   

    

    public Appointment createAppointment(String serviceType, String name) {
        if (serviceType.equalsIgnoreCase("electrician") && isElectricianAvailable ) {
            return new ElectricalAppointment();
        } else if (serviceType.equalsIgnoreCase("plumber") && isPlumberAvailable) {
            return new PlumbingAppointment();
        } else {
            throw new IllegalArgumentException("Invalid appointment type or no available appointments.");
        }
    }
    
}

