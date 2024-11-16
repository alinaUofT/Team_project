package use_case.home;

/**
 * The Change Password Use Case.
 */
public interface HomeInputBoundary {

    /**
     * Executes the Switch to Watchlists View Use Case.
     * @param username username of the currently logged-in user
     */
    void switchToWatchlistsView(String username);
}
