package use_case.search_results;

/**
 * Input Boundary for actions which are related to search results.
 */
public interface SearchResultsInputBoundary {

    /**
     * Executes the search results use case.
     * @param searchResultsInputData the input data
     */
    void execute(SearchResultsInputData searchResultsInputData);

    /**
     * Executes the switch to movie view use case.
     */
    void switchToHomeView();

    /**
     * Executes the switch to movie view use case.
     */
    void switchToMovieView();
}
