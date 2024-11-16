package interface_adapter.movie;

import interface_adapter.ViewManagerModel;
import use_case.movie.MovieOutputBoundary;

/**
 * The Presenter for the Login Use Case.
 */
public class MoviePresenter implements MovieOutputBoundary {

    private final MovieViewModel movieViewModel;
    private final ViewManagerModel viewManagerModel;
    // private final HomeViewModel homeViewModel;
    // TODO add the homeViewModel

    public MoviePresenter(MovieViewModel movieViewModel, ViewManagerModel viewManagerModel) {
        this.movieViewModel = movieViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // TODO add these
    @Override
    public void switchToHomeView() {

    }

    @Override
    public void switchToUserReviewsView() {

    }
}
