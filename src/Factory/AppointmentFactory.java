package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentFactory {
    private Connection con;

    
    private static final String CON_URL = "jdbc:mysql://localhost:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "Ar@121963";
    private static final String DATABASE_NAME = "AnwarDB";


    String name;

    public AppointmentFactory() {
        try {
            Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public Appointment createAppointment(String type, String name) {
        if (type.equalsIgnoreCase("electrician") && isElectricianAvailable(name)) {
            return new ElectricalAppointment();
        } else if (type.equalsIgnoreCase("plumber") && isPlumberAvailable(name)) {
            return new PlumbingAppointment();
        } else {
            throw new IllegalArgumentException("Invalid appointment type or no available appointments.");
        }
    }
    
}

