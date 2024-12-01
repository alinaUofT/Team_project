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
    private Movie currentMovie;
    private boolean watched;
    private String title = "";
    private String posterPath = "";
    private String overview = "";
    private String externalStarRating = "";
    private List<String> genres = new ArrayList<>();

    private Double starRating;
    private List<String> reviews;

    private String movieError;

    public MovieState() {
    }

    public void update(User currentUser, Movie currentMovie, boolean watched) {
        this.currentUser = currentUser;
        this.currentMovie = currentMovie;
        this.watched = watched;
        this.title = currentMovie.getTitle();
        this.starRating = currentMovie.getStarRatings();
        this.reviews = currentMovie.getUserReviews();
        this.externalStarRating = currentMovie.getVoterAverage();
        this.genres = currentMovie.getGenres();
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

    public Movie getCurrentMovie() {
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
        this.externalStarRating = voteAverage;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public String getExternalStarRating() {
        return externalStarRating;
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
                + ", externalStarRating='" + externalStarRating
                + ", genres=" + genres
                + '}';

    }
}
