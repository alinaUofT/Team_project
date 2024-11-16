package use_case.watchlists;

/**
 * The Input Data for the Signup Use Case.
 */
public class WatchlistsInputData {

    private final String username;
    private final String password;

    public WatchlistsInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
