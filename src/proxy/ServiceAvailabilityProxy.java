package proxy;
import java.sql.*;

public class ServiceAvailabilityProxy implements ServiceAvailability {
    private RealServiceAvailability realServiceAvailability;
    private String serviceType;
    private Connection con;


    private static final String CON_URL = "jdbc:mysql://localhost:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "12345";
    private static final String DATABASE_NAME = "AnwarDB";


    public ServiceAvailabilityProxy(String serviceType) {
        this.serviceType = serviceType;
        realServiceAvailability = new RealServiceAvailability();

            try {
                Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


    @Override
    public boolean isServiceAvailable(String serviceType) {
        // Additional logic in proxy before delegating to real subject
        System.out.println("Checking service availability for " + serviceType);


        return realServiceAvailability.isServiceAvailable(serviceType);
    }
    public boolean isPlumberAvailable(String name) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT available FROM technician_info WHERE name = '" + name + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isElectricianAvailable(String name) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT available FROM technician_info WHERE name = '" + name + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}