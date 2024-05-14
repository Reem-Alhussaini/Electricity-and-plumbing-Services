package Factory;

import proxy.ServiceAvailability;

// Concrete class for Electrical appointments
public class ElectricalAppointment implements Appointment {
    ServiceAvailability proxy;

    public ElectricalAppointment(ServiceAvailability proxy) {
        this.proxy = proxy;

    }
    @Override
    public String schedule() {
        //find an available electrician using proxy
        String serviceProviderName = proxy.isElectricianAvailable();

        //change the availability of the service provider
        proxy.changeState(serviceProviderName);

        System.out.println("Electrical appointment scheduled");
        return  serviceProviderName;
    }


}