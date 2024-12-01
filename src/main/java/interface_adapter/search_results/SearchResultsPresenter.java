package interface_adapter.search_results;

import entity.CommonMovie;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.movie.MovieViewModel;
import use_case.search_results.SearchResultsOutputBoundary;
import use_case.search_results.SearchResultsOutputData;

import java.util.List;

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

    public void setInformation() {
        searchResultsViewModel.getState().getMovieTitles();
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
    public void switchToMovieView(SearchResultsOutputData searchResultsOutputData, String movieTitle) {
        // Get the results from the output data
        final List<CommonMovie> results = searchResultsOutputData.getResults();

//        movieViewModel.
//
//        // Access the data to update the movie title
//
//
//        // Update the state
//
//        // Update the state
//        movieViewModel.getState().setTitle();

        viewManagerModel.setState(movieViewModel.getViewName());

        // Notify the view of changes
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(SearchResultsOutputData searchResultsOutputData) {
        // Access the current state from the ViewModel
        final SearchResultsState searchResultsState = searchResultsViewModel.getState();

        // Update the state
        searchResultsState.setSearchTitle(searchResultsOutputData.getSearchText());
        searchResultsState.setMovieTitles(searchResultsOutputData.getMovieTitles());
        searchResultsState.setPosterPaths(searchResultsOutputData.getPosterPaths());

        // Notify the view of changes
        searchResultsViewModel.firePropertyChanged();
    }
}
