package use_case.search_results;

import java.util.List;

/**
 * Output Data for the Search Results Use Case.
 */
public class SearchResultsOutputData {

    private final String searchText;
    private final List<String> results;

    public SearchResultsOutputData(String searchText, List<String> results) {
        this.searchText = searchText;
        this.results = results;
    }

    public String getSearchText() {
        return searchText;
    }

    public List<String> getResults() {
        return results;
    }
}
