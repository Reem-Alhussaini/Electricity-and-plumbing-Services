package proxy;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealDataBase implements ServiceAvailability {

    private RealDataBase realdatabase;
    private String serviceType;


    private static final String CON_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "Ar@121963";
    private static final String DATABASE_NAME = "AnwarDB";


    public RealDataBase() {
        try {
            Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//-------------------------------------------------------------------------------------------------
    public static void start(){
        createDB();

        createInvoiceTable();
        createUserTable();
        createTechnicianTable();

        insertUserTable();
        insertTechnicianTable();
    }
//-------------------------------------------------------------------------------------------------
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
//-------------------------------------------------------------------------------------------------
    private static void createInvoiceTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String table = "CREATE TABLE IF NOT EXISTS invoices (" +
                    "customer VARCHAR(100), " +
                    "service_provider_name VARCHAR(100), " +
                    "service VARCHAR(100), " +
                    "date DATE, " +
                    "price INT)";
            st.executeUpdate(table);
            System.out.println("invoices Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

//-------------------------------------------------------------------------------------------------
    private static void createUserTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createUserTable = "CREATE TABLE user_info (" +
                    "name VARCHAR(255)," +
                    "email VARCHAR(255)," +
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

//-------------------------------------------------------------------------------------------------
    private static void createTechnicianTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createTechnicianTable = "CREATE TABLE technician_info (" +
                    "name VARCHAR(255)," +
                    "phoneNum VARCHAR(200)," +
                    "type VARCHAR(200)," +
                    "available boolean," +
                    "servicePrice int," +
                    "rating float" +
                    ")";
            st.executeUpdate(createTechnicianTable);
            System.out.println("technician_info Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

//------------------------------------| insertion |--------------------------------------//
    private static void insertUserTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String insertUserTable = "INSERT INTO user_info (name, email, phone_number, password) VALUES " +
                    "('mohammed', 'moh@gmail.com', '0548888888', 'password')," +
                    "('amjad', 'amjad2001@gmail.com','0548888293', 'password')," +
                    "('aseel', 'aseel@hotmail.com','0546528888', 'password')," +
                    "('Othman', 'othman7@gmail.com','0548888398', 'password')," +
                    "('Sameer', 'sameer1995@hotmail.com','0548073881', 'password')";
            st.executeUpdate(insertUserTable);

            System.out.println("records inserted into user_info Table");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

//-------------------------------------------------------------------------------------------------
    private static void insertTechnicianTable(){
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String insertTechnicianTable = "INSERT INTO technician_info (name, phoneNum, type, available, servicePrice, rating) VALUES " +
                    "('jaleel','0548888888', 'plumber' ,TRUE, 300, 0.0), " +
                    "('abdulkareem', '0548888888', 'plumber', TRUE, 300, 0.0)," +
                    "('jamal', '0548888888', 'plumber', TRUE, 300, 0.0)," +
                    "('saeed', '0548888888', 'electrician', TRUE, 250, 0.0)," +
                    "('ibrahim', '0548888888', 'electrician', TRUE, 250, 0.0)";

            st.executeUpdate(insertTechnicianTable);

            System.out.println("records inserted into technician_info Table");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

//-----------------this method is called separately in main when creating an invoice----------------

    public static void insertInvoices(String customer, String service_provider_name, String service, Date date, int price) {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

            String insertQuery = "INSERT INTO invoices (customer, service_provider_name, service, date, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

            preparedStatement.setString(1, customer);
            preparedStatement.setString(2, service_provider_name);
            preparedStatement.setString(3, service);

            // Format the date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date);

            preparedStatement.setString(4, formattedDate);
            preparedStatement.setInt(5, price);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            preparedStatement.close();

            System.out.println("Invoice inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Couldn't insert invoice");
            e.printStackTrace();
        }
    }

    //-------------------------------------------------------------------------------------------------
    @Override
    public String isPlumberAvailable() {
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {
            PreparedStatement statement = con.prepareStatement("SELECT name FROM technician_info WHERE available = TRUE AND type = 'plumber'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            else{
                return "no plumber available";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//-------------------------------------------------------------------------------------------------
    @Override
    public String isElectricianAvailable() {
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {
            PreparedStatement statement = con.prepareStatement("SELECT name FROM technician_info WHERE available = TRUE AND type = 'electrician'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
            else{
                return "no electrician available";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//-------------------------------------------------------------------------------------------------
    public String changeState(String name) {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement("UPDATE technician_info SET available = ? WHERE name = ?")) {

            // Set parameters using PreparedStatement
            statement.setBoolean(1, false); // Set available to FALSE
            statement.setString(2, name);   // Set name parameter

            int rowsAffected = statement.executeUpdate(); // Use executeUpdate() for UPDATE query

            if (rowsAffected > 0) {
                return "State changed";
            } else {
                return "No technician found with the given name";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return  "couldn't change state"; // Return an error message
        }
    }

    //-------------------------------------------------------------------------------------------------
    public int getPrice(String name){
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {

            PreparedStatement statement = con.prepareStatement("SELECT servicePrice FROM technician_info WHERE name = '" + name + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //-------------------------------------------------------------------------------------------------

    public String changeRating(String name, float rating) {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement("UPDATE technician_info SET rating = ? WHERE name = ?")) {

            // Set parameters using PreparedStatement
            statement.setFloat(1, rating); // change rating
            statement.setString(2, name);   // Set name parameter

            int rowsAffected = statement.executeUpdate(); // Use executeUpdate() for UPDATE query

            if (rowsAffected > 0) {
                return "Rating Updated";
            } else {
                return "No technician found with the given name";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return  "couldn't update Rating"; // Return an error message
        }
    }
}