public class ServiceAvailabilityProxy implements ServiceAvailability {
    private RealServiceAvailability realServiceAvailability;

    public ServiceAvailabilityProxy() {
        // Lazy initialization of real subject
        realServiceAvailability = new RealServiceAvailability();
    }

    @Override
    public boolean isServiceAvailable(String serviceType) {
        // Additional logic in proxy before delegating to real subject
        System.out.println("Checking service availability for " + serviceType);

        // Delegating to real subject
        return realServiceAvailability.isServiceAvailable(serviceType);
    }
}