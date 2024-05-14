package Strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;


//User can login by email
public class EmailLoginStrategy implements LoginStrategy {

    //database
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/AnwarDB?user=root";
    private static final String USERNAME = "root";
    //change the password to your password
    private static final String PASSWORD = "Ar@121963";



    @Override
    public String login() throws SQLException {
        try (Connection connection = getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_info WHERE email = ? AND password = ?")) {
            //scanner to read user input
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter email: ");
            String email = userInput.nextLine();

            System.out.print("Enter password: ");
            String password = userInput.nextLine();

            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    System.out.println("Login successful!");
                    return email; // Return the email if login is successful
                } else {
                    System.out.println("Invalid email or password. Please try again.");
                    return login(); // Recursive call to allow the user to try again
                }
            }
        }
    }

}
