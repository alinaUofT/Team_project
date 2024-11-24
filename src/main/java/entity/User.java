package entity;

import java.util.List;

/**
 * The representation of a user in our program.
 */
public interface User {

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    String getName();

    /**
     * Returns the password of the user.
     * @return the password of the user.
     */
    String getPassword();

    /**
     * Returns the login status of the user.
     * @return the login status of the user.
     */
    boolean getLoginStatus();

    /**
     * Returns the user created watchlists of the user.
     * @return list of watchlists of the user.
     */
    List<UserWatchlist> getWatchlists();

    /**
     * Get the previously watched list of this User.
     * @return previously watched list
     */
    Watchlist getPwl();

    /**
     * Adds a genre to the list of preferred genres of this User.
     * @param genre a genre to add to the list
     */
    void addPreferredGenres(String genre);

    /**
     * Adds a list of genres to the list of preferred genres of this User.
     * @param genres a list of genres
     */
    void addPreferredGenres(List<String> genres);

    /**
     * Get reviews written by this User.
     * @return list of reviews
     */
    List<MovieReview> getRatingsAndReviews();

    /**
     * Check if this User watched the movie before.
     * @param movie in question
     * @return if the user watched this movie
     */
    boolean watchedBefore(Movie movie);
}
