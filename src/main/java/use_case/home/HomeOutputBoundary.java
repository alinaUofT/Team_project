package use_case.home;

import entity.User;

/**
 * The output boundary for the Change Password Use Case.
 */
public interface HomeOutputBoundary {

    /**
     * Switches to the Watchlists View.
     * @param user currently logged in user
     */
    void switchToWatchlistsView(User user);
}
