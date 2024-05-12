package proxy;
import java.sql.*;

public class DataBaseProxy implements ServiceAvailability {
    private RealDataBase realdatabase;
    private String serviceType;
    private Connection con;

    @Override
    public boolean isServiceAvailable(String serviceType) {
        // Additional logic in proxy before delegating to real subject
        System.out.println("Checking service availability for " + serviceType + "...");

        if (realdatabase == null){
            realdatabase = new RealDataBase(serviceType);
        }
        return realdatabase.isServiceAvailable(serviceType);
    }
}
