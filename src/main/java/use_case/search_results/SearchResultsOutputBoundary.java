package use_case.search_results;

/**
 * The output boundary for the Search Results Use Case.
 */
public interface SearchResultsOutputBoundary {

    /**
     * Prepares the failure view for the Login Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();

    /**
     * Switches to the Movie View.
     */
    void switchToMovieView();
}
