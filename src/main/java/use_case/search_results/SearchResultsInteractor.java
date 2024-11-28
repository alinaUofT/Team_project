package use_case.search_results;

import data_access.MovieDBAccessObject;

import java.util.List;

/**
 * The Search Results Interactor.
 */
public class SearchResultsInteractor implements SearchResultsInputBoundary {
    private final SearchResultsOutputBoundary searchResultsPresenter;

    private final MovieDBAccessObject movieDataAccessInterface;

    public SearchResultsInteractor(MovieDBAccessObject movieDBAccessObject,
                                   SearchResultsOutputBoundary searchResultsOutputBoundary) {
        this.searchResultsPresenter = searchResultsOutputBoundary;
        this.movieDataAccessInterface = movieDBAccessObject;
    }

    @Override
    public void execute(SearchResultsInputData searchResultsInputData) {
        final String searchText = searchResultsInputData.getSearchText();
    }

    /**
     * Executes the switch to Home view use case.
     */
    @Override
    public void switchToHomeView() {
        searchResultsPresenter.switchToHomeView();
    }

    /**
     * Executes the switch to movie view use case.
     */
    @Override
    public void switchToMovieView() {
        searchResultsPresenter.switchToMovieView();

    }
}
