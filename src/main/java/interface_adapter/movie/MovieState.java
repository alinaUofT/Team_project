package interface_adapter.movie;

import java.util.ArrayList;
import java.util.List;

import entity.CommonMovie;
import entity.Movie;
import entity.User;

/**
 * The state for the Movie View Model.
 */
public class MovieState {
    private User currentUser;

    private String title = "";
    private String posterPath = "";
    private String overview = "";
    private String voteAverage = "";
    private List<String> genres = new ArrayList<>();

    private int starRating;
    private String reviews = "";

    private CommonMovie currentMovie;
    private String movieError;

    public MovieState() {
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentMovie(CommonMovie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public CommonMovie getCurrentMovie() {
        return this.currentMovie;
    }

    // Information for the view

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setMovieError(String movieError) {
        this.movieError = movieError;
    }

    public String getMovieError() {
        return movieError;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getStarRating() {
        return String.valueOf(starRating);
    }

    public String getReviews() {
        return reviews;
    }

    /**
     * Returns a string representation of the MovieState object.
     *
     * @return a string representation of the MovieState object
     */
    @Override
    public String toString() {
        return "MovieState{"
                + "currentUser='" + currentUser
                + ", title='" + title
                + ", starRating=" + starRating
                + ", reviews=" + reviews
                + ", externalStarRating='" + voteAverage
                + ", genres=" + genres
                + '}';

    }
}
