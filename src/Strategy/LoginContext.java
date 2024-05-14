package Strategy;

import java.sql.SQLException;

public class LoginContext {
    private LoginStrategy loginStrategy;

    // Method to set the strategy dynamically
    public void setLoginStrategy(LoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    // Method to perform login using the selected strategy
    public String performLogin() throws SQLException {
        if (loginStrategy == null) {
            throw new IllegalStateException("Login strategy is not set.");
        }
        return loginStrategy.login();
    }
}
