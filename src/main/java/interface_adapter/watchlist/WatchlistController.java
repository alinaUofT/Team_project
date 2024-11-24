package interface_adapter.watchlist;

import entity.User;
import use_case.watchlist.WatchlistInputBoundary;

/**
 * Controller for the Signup Use Case.
 */
public class WatchlistController {

    private final WatchlistInputBoundary watchlistInteractor;

    public WatchlistController(WatchlistInputBoundary watchlistInteractor) {
        this.watchlistInteractor = watchlistInteractor;
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        watchlistInteractor.switchToHomeView();
    }

    /**
     * Executes the "switch to WatchlistView" Use Case.
     * @param currentUser user that is currently logged in
     * @param ind index that corresponds to the watchlist to switch to
     */
    public void goToWatchlist(User currentUser, int ind) {
        watchlistInteractor.switchToWatchlistView(currentUser, ind);
    }

    /**
     * Executes the "switch to PWLView" Use Case.
     * @param currentUser user that is currently logged in
     */
    public void goToPWL(User currentUser) {
        watchlistInteractor.switchToPWL(currentUser);
    }
}
