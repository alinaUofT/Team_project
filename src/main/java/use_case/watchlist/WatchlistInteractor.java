package use_case.watchlist;

import entity.User;
import entity.UserFactory;

/**
 * The Watchlists Interactor.
 */
public class WatchlistInteractor implements WatchlistInputBoundary {
    private final WatchlistUserDataAccessInterface userDataAccessObject;
    private final WatchlistOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public WatchlistInteractor(WatchlistUserDataAccessInterface watchlistDataAccessInterface,
                               WatchlistOutputBoundary watchlistOutputBoundary,
                               UserFactory userFactory) {
        this.userDataAccessObject = watchlistDataAccessInterface;
        this.userPresenter = watchlistOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void switchToHomeView() {
        userPresenter.switchToHomeView();
    }

    /**
     * Executes the switch to watchlist view use case.
     *
     * @param currentUser user that is currently logged in
     * @param ind         index that corresponds to the watchlist to switch to
     */
    @Override
    public void switchToWatchlistView(User currentUser, int ind) {
        userPresenter.switchToWatchlistView(currentUser, ind);
    }

    /**
     * Executes the switch to PWL view use case.
     *
     * @param currentUser user that is currently logged in
     */
    @Override
    public void switchToPWL(User currentUser) {
        userPresenter.switchToPWLView(currentUser);
    }
}
