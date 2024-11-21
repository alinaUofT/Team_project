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

    // TODO I don't think storing login status is useful.
    // We store current user in the view states already
    // because we need to access their instance attributes.

    private boolean loginStatus;
    private List<String> preferredGenres = new ArrayList<>();
    private PrWatched pwl = new Watchlist();
    private List<UserWatchlist> watchlists = new ArrayList<>();
    private List<MovieReview> ratingsAndReviews = new ArrayList<>();

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.loginStatus = false;
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
     * Returns the user created watchlists of the user.
     *
     * @return list of watchlists of the user.
     */
    @Override
    public List<UserWatchlist> getWatchlists() {
        return this.watchlists;
    }


}
