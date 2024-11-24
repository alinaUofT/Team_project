package entity;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;



/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private final String password;
    // TODO update the interface

    // TODO I don't think storing login status is useful.
    // We store current user in the view states already
    // because we need to access their instance attributes.

    private boolean loginStatus;
    private List<String> preferredGenres = new ArrayList<>();
    private Watchlist pwl = new CommonWatchlist();
    private ArrayList<UserWatchlist> watchlists = new ArrayList<>();

    private List<MovieReview> ratingsAndReviews = new ArrayList<>();

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.loginStatus = false;
        this.preferredGenres = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean getLoginStatus() {
        return loginStatus;
    }

    /**
     * Get the previously watched list of this User.
     * @return previously watched list
     */
    @Override
    public Watchlist getPwl() {
        return this.pwl;
    }

    /**
     * Returns the user created watchlists of the user.
     *
     * @return list of watchlists of the user.
     */
    @Override
    public ArrayList<UserWatchlist> getWatchlists() {
        return (ArrayList<UserWatchlist>) this.watchlists;
    }

    @Override
    public List<String> getPreferredGenres() {
        return this.preferredGenres;
    }

    /**
     * Adds a genre to the list of preferred genres of this User.
     * @param genre a genre to add to the list
     */
    @Override
    public void addPreferredGenres(String genre) {
        if (!this.preferredGenres.contains(genre)) {
            this.preferredGenres.add(genre);
        }
    }

    /**
     * Adds a list of genres to the list of preferred genres of this User.
     * @param genres a list of genres
     */
    @Override
    public void addPreferredGenres(List<String> genres) {
        for (String genre : genres) {
            if (!this.preferredGenres.contains(genre)) {
                this.preferredGenres.add(genre);
            }
        }
    }

    /**
     * Get reviews written by this User.
     * @return list of reviews
     */
    @Override
    public List<MovieReview> getRatingsAndReviews() {
        return this.ratingsAndReviews;
    }

    /**
     * Check if this User watched the movie before.
     *
     * @param movie in question
     * @return if the user watched this movie
     */
    @Override
    public boolean watchedBefore(Movie movie) {
        return this.pwl.contains(movie);
    }
}
