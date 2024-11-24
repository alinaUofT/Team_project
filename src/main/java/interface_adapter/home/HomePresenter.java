package interface_adapter.home;

import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.recommendations.RecommendationsViewModel;
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
    private final RecommendationsViewModel recommendationsViewModel;

    public HomePresenter(ViewManagerModel viewManagerModel,
                           WatchlistsViewModel watchlistsViewModel, RecommendationsViewModel recommendationsViewModel, HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.watchlistsViewModel = watchlistsViewModel;
        this.recommendationsViewModel = recommendationsViewModel;

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

    /**
     * Switches to the Recommendations View.
     */
    @Override
    public void switchToRecommendationsView(User user) {
        recommendationsViewModel.getState().setCurrentUser(user);
        viewManagerModel.setState(recommendationsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
