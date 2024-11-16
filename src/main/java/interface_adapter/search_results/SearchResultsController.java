package interface_adapter.search_results;

// TODO add search results input data and boundary
// import use_case.search_results.SearchResultsInputBoundary;
// import use_case.search_results.SearchResultsInputData;

/**
 * Controller for the Search Results Use Case.
 */
public class SearchResultsController {
    private final SearchResultsInputBoundary searchResultsUseCaseInteractor;

    public SearchResultsController(SearchResultsInputBoundary searchResultsUseCaseInteractor) {
        this.searchResultsUseCaseInteractor = searchResultsUseCaseInteractor;
    }

    /**
     * Executes the search Use Case.
     * @param title the title of the movie
     */
    public void execute(String title) {
        final SearchResultsInputData searchResultsInputData = new SearchResultsInputData(
                title);

        searchResultsUseCaseInteractor.execute(searchResultsInputData);
    }
}
