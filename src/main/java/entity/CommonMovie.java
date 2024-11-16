package entity;

import java.util.List;

/**
 * A simple implementation of the Movie interface.
 */
public class CommonMovie implements Movie {

    // TODO: assign the variables for starRating, userReviews, genres
    private final String title;
    private int starRating;
    private List<String> userReviews;
    private List<String> genres;

    public CommonMovie(String title) {
        this.title = title;

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getStarRatings() {
        return starRating;
    }

    @Override
    public List<String> getUserReviews() {
        return userReviews;
    }

    @Override
    public List<String> getGenres() {
        return genres;
    }
}
