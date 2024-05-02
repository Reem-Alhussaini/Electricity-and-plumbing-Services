package builder;

import java.sql.*;

//this class must be run first and never again (one time use)
public class Database {
    //add the jar file
    private static final String CON_URL = "jdbc:mysql://localhost:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "Ar@121963";
    private static final String DATABASE_NAME = "AnwarDB";

    public static void main(String[] args) {
        //remove comments of the calls to create the database and table
//        createDB();
//        createInvoiceTable();
//        createUserTable();
//        createTechnicianTable();
//        insertUserTable();
        insertTechnicianTable();

    }
//------------------------------------------------------------------------------------------------------------------

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

    //------------------------------------------------------------------------------------------------------------------
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
    //------------------------------------------------------------------------------------------------------------------
    private static void createUserTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createUserTable = "CREATE TABLE user_info (" +
                    "name VARCHAR(255)," +
                    "phone_number VARCHAR(20)," +
                    "password VARCHAR(20)" +
                    ")";
            st.executeUpdate(createUserTable);
            System.out.println("user_info Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    private static void createTechnicianTable() {
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String createTechnicianTable = "CREATE TABLE technician_info (" +
                    "name VARCHAR(255)," +
                    "available boolean" +
                    ")";
            st.executeUpdate(createTechnicianTable);
            System.out.println("technician_info Table created");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
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
//------------------------------------------------------------------------------------------------------------------

    private static void insertTechnicianTable(){
        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String insertTechnicianTable = "INSERT INTO technician_info (name, available) VALUES " +
                    "('jaleel', TRUE), " +
                    "('abdulkareem', TRUE)," +
                    "('jamal', TRUE)," +
                    "('saeed', TRUE)," +
                    "('ibrahim', TRUE)";
            st.executeUpdate(insertTechnicianTable);

            System.out.println("records inserted into technician_info Table");

        } catch (SQLException e) {
            System.out.println("Couldn't create table or table already created");
            e.printStackTrace();
        }
    }

//------------------------------------------------------------------------------------------------------------------

    //    private static void insertInvoices() {
//        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
//            String[][] records = {
//                    {"Customer 1", "Plumber Provider 1", "Plumbing Service", "2024-04-26", "100.00"},
//                    {"Customer 2", "Plumber Provider 2", "Electrical Service", "2024-04-27", "150.00"},
//                    {"Customer 3", "Electrician Provider 1", "HVAC Service", "2024-04-28", "200.00"}
//            };
//
//            String insertQuery = "INSERT INTO invoices (name, service_provider_name, service, date, price) VALUES (?, ?, ?, ?, ?)";
//
//            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
//
//            for (String[] record : records) {
//                preparedStatement.setString(1, record[0]);
//                preparedStatement.setString(2, record[1]);
//                preparedStatement.setString(3, record[2]);
//                preparedStatement.setString(4, record[3]);
//                preparedStatement.setFloat(5, Float.parseFloat(record[4]));
//                preparedStatement.addBatch();
//            }
//
//            preparedStatement.executeBatch();
//            preparedStatement.close();
//
//            System.out.println("Invoices inserted successfully!");
//
//        } catch (SQLException e) {
//            System.out.println("Couldn't insert records or records already inserted");
//            e.printStackTrace();
//        }
//    }
}
