public class Login {
    private Authenticator authenticator;

    public Login(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public boolean login(String username, String password) {
        // Delegate authentication to the strategy
        return authenticator.authenticate(username, password);
    }
}
