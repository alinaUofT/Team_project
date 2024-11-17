package use_case.home;

/**
 * The input data for the Change Password Use Case.
 */
public class HomeInputData {

    private final String password;
    private final String username;

    public HomeInputData(String password, String username) {
        this.password = password;
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

}
