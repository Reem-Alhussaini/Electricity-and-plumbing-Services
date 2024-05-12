package proxy.src;
import java.sql.*;

public class RealDataBase implements ServiceAvailability {

    private RealDataBase realdatabase;
    private String serviceType;
    private Connection con;


    private static final String CON_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "1234";
    private static final String DATABASE_NAME = "AnwarDB";


    public RealDataBase(String serviceType) {
        this.serviceType = serviceType;

        try {
            Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDB() {
        try (Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            st.executeUpdate("CREATE DATABASE " + DATABASE_NAME);
            System.out.println("Database created");

        } catch (SQLException e) {
            System.out.println("Couldn't create AnwarDB database or database already created");
            System.out.println("Check if you changed the password and added the jar file");
            e.printStackTrace();
        }
    }

    private static void createInvoiceTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String table = "CREATE TABLE IF NOT EXISTS invoices (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "service_provider_name VARCHAR(100), " +
                    "service VARCHAR(100), " +
                    "date DATE, " +
                    "price FLOAT)";
            st.executeUpdate(table);
            System.out.println("invoices Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

    private static void createUserTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createUserTable = "CREATE TABLE user_info (" +
                    "name VARCHAR(255)," +
                    "phone_number VARCHAR(200)," +
                    "password VARCHAR(200)" +
                    ")";
            st.executeUpdate(createUserTable);
            System.out.println("user_info Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

    private static void createTechnicianTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createTechnicianTable = "CREATE TABLE technician_info (" +
                    "name VARCHAR(255)," +
                    "phoneNum VARCHAR(200)" +
                    "type VARCHAR(200)" +
                    "available boolean" +
                    ")";
            st.executeUpdate(createTechnicianTable);
            System.out.println("technician_info Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------//
    @Override
    public boolean isServiceAvailable(String serviceType) {

        return isPlumberAvailable(serviceType) || isElectricianAvailable(serviceType);

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