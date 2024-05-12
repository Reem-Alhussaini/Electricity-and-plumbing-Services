import java.sql.*;

//this class must be run first and never again (one time use)
public class Database {
    //add the jar file
//    private static final String CON_URL = "jdbc:mysql://localhost:3306/?user=root";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/AnwarDB?user=root";
//    private static final String USERNAME = "root";
//    //change the password to your password
//    private static final String PASSWORD = "12345";
//    private static final String DATABASE_NAME = "AnwarDB";


//------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
//    private static void insertUserTable() {
//        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//             Statement st = con.createStatement()) {
//
//            String insertUserTable = "INSERT INTO user_info (name, phone_number, password) VALUES " +
//                    "('mohammed', '0548888888', 'password')," +
//                    "('amjad', '0548888293', 'password')," +
//                    "('aseel', '0546528888', 'password')," +
//                    "('Othman', '0548888398', 'password')," +
//                    "('Sameer', '0548073881', 'password')";
//            st.executeUpdate(insertUserTable);
//
//            System.out.println("records inserted into user_info Table");
//
//        } catch (SQLException e) {
//            System.out.println("Couldn't create table or table already created");
//            e.printStackTrace();
//        }
//    }
//------------------------------------------------------------------------------------------------------------------

//    private static void insertTechnicianTable(){
//        try (Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//             Statement st = con.createStatement()) {
//
//            String insertTechnicianTable = "INSERT INTO technician_info (name, phoneNum, type, available) VALUES " +
//                    "('jaleel','0548888888', 'pulmber' ,TRUE), " +
//                    "('abdulkareem', '0548888888', 'pulmer', TRUE)," +
//                    "('jamal', '0548888888', 'pulmber', TRUE)," +
//                    "('saeed', '0548888888', 'electritian', TRUE)," +
//                    "('ibrahim', '0548888888', 'electritian', TRUE)";
//
//            st.executeUpdate(insertTechnicianTable);
//
//            System.out.println("records inserted into technician_info Table");
//
//        } catch (SQLException e) {
//            System.out.println("Couldn't create table or table already created");
//            e.printStackTrace();
//        }
//    }

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
