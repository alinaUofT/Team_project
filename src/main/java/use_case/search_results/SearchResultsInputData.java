package use_case.search_results;

import java.util.ArrayList;
import java.util.List;

import data_access.APIMovieAccess;

/**
 * The Input Data for the Search Results Use Case.
 */
public class SearchResultsInputData {
    private final String searchText;
    private final List<String> movieTitles;
    private final List<String> posterPaths;

    public SearchResultsInputData(String searchText) {
        this.searchText = searchText;
        this.movieTitles = new ArrayList<>();
        this.posterPaths = new ArrayList<>();

        updateTitleAndPoster();
    }

    public String getSearchText() {
        return searchText;
    }

    public List<String> getMovieTitles() {
        return movieTitles;
    }

    public List<String> getPosterPaths() {
        return posterPaths;
    }

    public int getNumResults() {
        return movieTitles.size();
    }

    /**
     * A helper function to get the titles and posters.
     */
    public void updateTitleAndPoster() {
        final List<Object> result = APIMovieAccess.formatedSearchedMovies(searchText);

        for (int i = 5; i < result.size(); i = i + 5) {
            final String title = (result.get(i - 5)).toString();
            final String poster = (result.get(i - 4)).toString();

            this.movieTitles.add(title);
            this.posterPaths.add(poster);
        }
    }
}
