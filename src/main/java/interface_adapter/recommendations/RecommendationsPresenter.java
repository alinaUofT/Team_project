package interface_adapter.recommendations;

import entity.Movie;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.movie.MovieViewModel;
import use_case.recommendations.RecommendationsOutputBoundary;

public class RecommendationsPresenter implements RecommendationsOutputBoundary {
    private final RecommendationsViewModel recommendationsViewModel;
    private final HomeViewModel homeViewModel;
    private final MovieViewModel movieViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecommendationsPresenter(ViewManagerModel viewManagerModel,
                               RecommendationsViewModel recommendationsViewModel, MovieViewModel movieViewModel,
                               HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.recommendationsViewModel = recommendationsViewModel;
        this.movieViewModel = movieViewModel;
    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the Movie View.
     *
     * @param currentUser user that is currently logged in
     * @param movie movie information to view
     */
    @Override
    public void switchToMovieView(User currentUser, Movie movie) {
        // should switch to watchlist view which is not implemented
        viewManagerModel.setState(movieViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
