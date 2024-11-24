package interface_adapter.movie;

import java.util.ArrayList;
import java.util.List;

import entity.Movie;
import entity.User;

/**
 * The state for the Login View Model.
 */
public class MovieState {
    private User currentUser;
    private Movie currentMovie;
    private String title = "";
    private int starRating;
    private String reviews = "";
    private String externalStarRating = "";
    private List<String> genres = new ArrayList<>();

    public MovieState() {

    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public Movie getCurrentMovie() {
        return this.currentMovie;
    }

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

    @Override
    public String toString() {
        return "MovieState{"
                + "currentUser='" + currentUser
                + "title='" + title
                + "starRating=" + starRating
                + "reviews='" + reviews
                + "externalStarRating='" + externalStarRating
                + "genres=" + genres
                + '}';
    }
}
