package Strategy;

import java.sql.SQLException;

public class LoginContext {
    private LoginStrategy loginStrategy;

    // Constructor
    public LoginContext(LoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    // Method to perform login using the selected strategy
    public String performLogin() throws SQLException {
        return loginStrategy.login();
    }
}
