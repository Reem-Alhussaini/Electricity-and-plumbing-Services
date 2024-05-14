package Strategy;

import java.sql.SQLException;

public interface LoginStrategy {
    String login() throws SQLException;
}
