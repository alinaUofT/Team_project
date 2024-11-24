package interface_adapter.watchlist;

import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import use_case.watchlist.WatchlistOutputBoundary;
import use_case.watchlists.WatchlistsOutputBoundary;

/**
 * The Presenter for the Signup Use Case.
 */
public class WatchlistPresenter implements WatchlistOutputBoundary {

    private final WatchlistViewModel watchlistViewModel;
    private final HomeViewModel homeViewModel;
    private final ViewManagerModel viewManagerModel;
//    private final WatchlistViewModel watchlistViewModel;

    public WatchlistPresenter(ViewManagerModel viewManagerModel,
                              WatchlistViewModel watchlistViewModel, HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.watchlistViewModel = watchlistViewModel;

    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the Watchlist View.
     *
     * @param currentUser user that is currently logged in
     * @param ind         index that corresponds to the watchlist to switch to
     */
    @Override
    public void switchToWatchlistView(User currentUser, int ind) {
        // should switch to watchlist view which is not implemented
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the PWL View.
     *
     * @param currentUser user that is currently logged in
     */
    @Override
    public void switchToPWLView(User currentUser) {
        // should switch to watchlist view which is not implemented
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
