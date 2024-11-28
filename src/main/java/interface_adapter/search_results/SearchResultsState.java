package interface_adapter.search_results;

/**
 * The state for the Search Results View Model.
 */
public class SearchResultsState {
    private String searchTitle = "";
    private String searchError;

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public String getSearchError() {
        return searchError;
    }

    public void setSearchResultsError(String errorMessage) {
        this.searchError = errorMessage;
    }

}
