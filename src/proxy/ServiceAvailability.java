package proxy;
public interface ServiceAvailability {
//    boolean isServiceAvailable(String serviceType);

    // trying separate
    String isPlumberAvailable();
    String isElectricianAvailable();
    String changeAvailability(String name);

    int getPrice(String name);
    String changeRating(String name, float rating);
    //String getService(String serviceType); // to get service type

}