package interface_adapter.home;

import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.watchlists.WatchlistsViewModel;
import use_case.home.HomeOutputBoundary;
import use_case.home.HomeUserDataAccessInterface;

/**
 * The Presenter for the Change Password Use Case.
 */
public class HomePresenter implements HomeOutputBoundary {

    private final HomeViewModel homeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final WatchlistsViewModel watchlistsViewModel;

    public HomePresenter(ViewManagerModel viewManagerModel,
                           WatchlistsViewModel watchlistsViewModel, HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.watchlistsViewModel = watchlistsViewModel;

    }

    /**
     * Switches to the Watchlists View.
     */
    @Override
    public void switchToWatchlistsView(User user) {
        watchlistsViewModel.getState().setCurrentUser(user);
        viewManagerModel.setState(watchlistsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
