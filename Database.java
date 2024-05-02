
package builder.builder;

import java.sql.*;

//this class must be run first and never again (one time use)
public class Database {
    //add the jar file
    private static final String CON_URL = "jdbc:mysql://localhost:3306/?user=root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_absence_monitoring?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "Ar@121963";
    private static final String DATABASE_NAME = "student_absence_monitoring";

    public static void main(String[] args) {
        //remove comments of the calls to create the database and table
        //createDB();
        //createTable();
        //insertStudents();
        createInvoiceTable();
        insertInvoices();

    }
    //----------------------------------------

    private static void createDB() {
        try (Connection con = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            st.executeUpdate("CREATE DATABASE " + DATABASE_NAME);
            System.out.println("Database created");

        } catch (SQLException e) {
            System.out.println("Couldn't create student_absence_monitoring database or database already created");
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
}