package interface_adapter.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Login View Model.
 */
public class MovieState {
    private String title = "";
    private int starRating;
    private String reviews = "";
    private String externalStarRating = "";
    private List<String> genres = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getStarRating() {
        return String.valueOf(starRating);
    }

    public String getReviews() {
        return reviews;
    }

    public String getExternalStarRating() {
        return externalStarRating;
    }
}
