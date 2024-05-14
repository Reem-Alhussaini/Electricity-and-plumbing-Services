package Factory;

import proxy.ServiceAvailability;

// Concrete class for Plumbing appointments
public class PlumbingAppointment implements Appointment {
    ServiceAvailability proxy;

    public PlumbingAppointment(ServiceAvailability proxy) {
        this.proxy = proxy;
    }
    @Override
    public String schedule() {
        //find an available plumber using proxy
        String serviceProviderName = proxy.isPlumberAvailable();

        //change the availability of the service provider
        proxy.changeState(serviceProviderName);

        System.out.println("Plumbing appointment scheduled");
        return  serviceProviderName;
    }

}
