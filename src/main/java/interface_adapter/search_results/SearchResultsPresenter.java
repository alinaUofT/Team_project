package interface_adapter.search_results;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.movie.MovieViewModel;
import use_case.search_results.SearchResultsOutputBoundary;

/**
 * The Presenter for the Search Results Use Case.
 */
public class SearchResultsPresenter implements SearchResultsOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SearchResultsViewModel searchResultsViewModel;
    private final HomeViewModel homeViewModel;
    private final MovieViewModel movieViewModel;

    public SearchResultsPresenter(ViewManagerModel viewManagerModel,
                                  SearchResultsViewModel searchResultsViewModel,
                                  HomeViewModel homeViewModel,
                                  MovieViewModel movieViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchResultsViewModel = searchResultsViewModel;
        this.homeViewModel = homeViewModel;
        this.movieViewModel = movieViewModel;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SearchResultsState searchResultsState = searchResultsViewModel.getState();
        searchResultsState.setSearchResultsError(errorMessage);
        searchResultsViewModel.firePropertyChanged();
    }

    /**
     * Switches to the Home View.
     */
    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the Movie View.
     */
    @Override
    public void switchToMovieView() {
        viewManagerModel.setState(movieViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
