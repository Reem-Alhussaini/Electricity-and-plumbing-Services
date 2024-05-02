public class Main {
    public static void main(String[] args) {
        Authenticator authenticator = new infoauthenticator();

        Login loginService = new Login(authenticator);
        boolean loggedIn = loginService.login("user", "pass");
        System.out.println("Logged in: " + loggedIn);
    }
}