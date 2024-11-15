package use_case.watchlists;

/**
 * The Input Data for the Signup Use Case.
 */
public class WatchlistsInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;

    public WatchlistsInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
