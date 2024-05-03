public interface Customer {
    public static void main(String[] args) {
        // Create a service availability proxy
        ServiceAvailability proxy = new ServiceAvailabilityProxy();

        // Check service availability
        boolean isElectricalServiceAvailable = proxy.isServiceAvailable("Electrical");
        boolean isPlumbingServiceAvailable = proxy.isServiceAvailable("Plumbing");

        // Display service availability
        System.out.println("Electrician " + "(electrician name from DB):" + isElectricalServiceAvailable);
        System.out.println("Plumber " + "(plumber name from DB):" + isPlumbingServiceAvailable);
    }
}