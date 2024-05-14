package proxy;

import java.sql.*;

public class RealDataBase implements ServiceAvailability {

    private RealDataBase realdatabase;
    private String serviceType;


    private static final String CON_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "1234";
    private static final String DATABASE_NAME = "AnwarDB";


    public RealDataBase() {
        try {
            Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void start(){
        createDB();
        createInvoiceTable();
        createUserTable();
        createTechnicianTable();
        insertUserTable();
        insertTechnicianTable();
        insertInvoices();
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
                    "phoneNum VARCHAR(200)," +
                    "type VARCHAR(200)," +
                    "available boolean," +
                    "servicePrice int" +
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

            String insertUserTable = "INSERT INTO user_info (name, phone_number, password) VALUES " +
                    "('mohammed', '0548888888', 'password')," +
                    "('amjad', '0548888293', 'password')," +
                    "('aseel', '0546528888', 'password')," +
                    "('Othman', '0548888398', 'password')," +
                    "('Sameer', '0548073881', 'password')";
            st.executeUpdate(insertUserTable);

            System.out.println("records inserted into user_info Table");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

    private static void insertTechnicianTable(){
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String insertTechnicianTable = "INSERT INTO technician_info (name, phoneNum, type, available, servicePrice) VALUES " +
                    "('jaleel','0548888888', 'pulmber' ,TRUE, 300), " +
                    "('abdulkareem', '0548888888', 'pulmber', TRUE, 300)," +
                    "('jamal', '0548888888', 'pulmber', TRUE, 300)," +
                    "('saeed', '0548888888', 'electritian', TRUE, 250)," +
                    "('ibrahim', '0548888888', 'electritian', TRUE, 250)";

            st.executeUpdate(insertTechnicianTable);

            System.out.println("records inserted into technician_info Table");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

    //insert invoice-----------------
    private static void insertInvoices() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String[][] records = {
                    {"Customer 1", "Plumber Provider 1", "Plumbing Service", "2024-04-26", "100.00"},
                    {"Customer 2", "Plumber Provider 2", "Electrical Service", "2024-04-27", "150.00"},
                    {"Customer 3", "Electrician Provider 1", "HVAC Service", "2024-04-28", "200.00"}
            };

            String insertQuery = "INSERT INTO invoices (name, service_provider_name, service, date, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

            for (String[] record : records) {
                preparedStatement.setString(1, record[0]);
                preparedStatement.setString(2, record[1]);
                preparedStatement.setString(3, record[2]);
                preparedStatement.setString(4, record[3]);
                preparedStatement.setFloat(5, Float.parseFloat(record[4]));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            preparedStatement.close();

            System.out.println("Invoices inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Couldn't insert records or records already inserted");
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------//
//    @Override
//    public boolean isServiceAvailable(String serviceType) {
//
//        return isPlumberAvailable(serviceType) || isElectricianAvailable(serviceType);
//
//    }

//    @Override
//    public boolean isServiceAvailable(String serviceType) {
//        return false;
//    }

    @Override
    public String isPlumberAvailable() {
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {
            PreparedStatement statement = con.prepareStatement("SELECT name FROM technician_info WHERE available = TRUE");
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
    @Override
    public String isElectricianAvailable() {
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {
            PreparedStatement statement = con.prepareStatement("SELECT name FROM technician_info WHERE available = TRUE");
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

    public String changeState(String name){
        try(Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);) {
            PreparedStatement statement = con.prepareStatement("UPDATE technician_info SET available = FALSE WHERE name = '" + name + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "State changed";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "couldn't change state";
    }

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
}