package use_case.watchlist;

import entity.User;

/**
 * Input Boundary for actions which are related to watchlists.
 */
public interface WatchlistInputBoundary {

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();

    /**
     * Executes the switch to watchlist view use case.
     * @param currentUser user that is currently logged in
     * @param ind index that corresponds to the watchlist to switch to
     */
    void switchToWatchlistView(User currentUser, int ind);

    /**
     * Executes the switch to PWL view use case.
     * @param currentUser user that is currently logged in
     */
    void switchToPWL(User currentUser);
}
