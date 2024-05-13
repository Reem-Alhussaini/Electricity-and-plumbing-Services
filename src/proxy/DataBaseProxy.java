package proxy;
import java.sql.*;

public class DataBaseProxy implements ServiceAvailability {
    private RealDataBase realdatabase;
    private String serviceType;

    private String name;

    public DataBaseProxy(String serviceType, String name){
        this.serviceType = serviceType;
        this.name = name;
    }


    //added these two methods, they both check if realdatabase is null
    @Override
    public boolean isPlumberAvailable(String name) {
        System.out.println("Checking service availability for " + name + "...");
        if (realdatabase == null){
           realdatabase = new RealDataBase(name);
       }
        return realdatabase.isPlumberAvailable(name);
    }

    @Override
    public int getPrice(String name) {
        System.out.println("getting service price...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.getPrice(name);
    }

    @Override
    public String changeState(String name) {
        System.out.println("changing availability...");
        if (realdatabase == null){
            realdatabase = new RealDataBase();
        }
        return realdatabase.changeState(name);
    }
}
