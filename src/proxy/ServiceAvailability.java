package proxy;
public interface ServiceAvailability {
//    boolean isServiceAvailable(String serviceType);

    // trying separate
    String isPlumberAvailable();
    String isElectricianAvailable();

    int getPrice(String name);
    String changeState(String name);
}
