package Factory;

// Concrete class for Plumbing appointments
public class PlumbingAppointment implements Appointment {
    public void schedule() {
        System.out.println("Plumbing appointment scheduled");
    }
}
