package proxy;
import java.sql.*;

public class DataBaseProxy implements ServiceAvailability {
    private RealDataBase realdatabase;
    private String serviceType;
    private Connection con;

    public DataBaseProxy(String serviceType){

    }
//    @Override
//    public boolean isServiceAvailable(String serviceType) {
//
//
//        System.out.println("Checking service availability for " + serviceType + "...");
//
//        if (realdatabase == null){
//            realdatabase = new RealDataBase(serviceType);
//        }
//        return realdatabase.isServiceAvailable(serviceType);
//    }

    @Override
    public String isPlumberAvailable() {
        System.out.println("Checking service availability for plumber...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.isPlumberAvailable();
    }

    @Override
    public String isElectricianAvailable() {
        System.out.println("Checking service availability for Electrician...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.isElectricianAvailable();
    }
}
