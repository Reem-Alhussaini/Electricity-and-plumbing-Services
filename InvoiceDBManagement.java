
package builder.builder;

import java.sql.*;

public class InvoiceDBManagement {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/invoice_database?user=root";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ar@121963";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
    }

    public static void insertInvoice(Invoice invoice) {
        try (Connection con = getConnection()) {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO invoices (name, service_provider_name, service, date, price) VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, invoice.getName());
            statement.setString(2, invoice.getServiceProviderName());
            statement.setString(3, invoice.getService());
            statement.setDate(4, new java.sql.Date(invoice.getDate().getTime()));
            statement.setString(5, invoice.getPrice());

            statement.executeUpdate();
            System.out.println("Invoice inserted successfully");
        } catch (SQLException e) {
            System.out.println("Couldn't insert invoice:");
            e.printStackTrace();
        }
    }

    public static void displayInvoices() {
        try (Connection con = getConnection()) {
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM invoices");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String serviceProviderName = result.getString("service_provider_name");
                String service = result.getString("service");
                Date date = result.getDate("date");
                String price = result.getString("price");

                System.out.println("Invoice ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Service Provider Name: " + serviceProviderName);
                System.out.println("Service: " + service);
                System.out.println("Date: " + date);
                System.out.println("Price: " + price + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Couldn't display invoices:");
            e.printStackTrace();
        }
    }

    
}
