package proxy;
import java.sql.*;

public class DataBaseProxy implements ServiceAvailability {
    private RealDataBase realdatabase;
    private String serviceType;


    public DataBaseProxy(String serviceType){

        this.serviceType = serviceType;
    }

    @Override
    public String isPlumberAvailable() {
        //System.out.println("Checking service availability for plumber..."); // printline moved to realDataBase method
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.isPlumberAvailable();
    }

    @Override
    public String isElectricianAvailable() {
        //System.out.println("Checking service availability for Electrician...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.isElectricianAvailable();
    }

    @Override
    public int getPrice(String name) {
        //System.out.println("getting service price...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.getPrice(name);
    }

    @Override
    public String changeAvailability(String name) {
        //System.out.println("changing availability...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.changeAvailability(name);
    }

    @Override
    public String changeRating(String name, float rating) {
        //System.out.println("updating rating...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.changeRating(name, rating);
    }
}