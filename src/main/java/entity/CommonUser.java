package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private final String password;

    // TODO - updated the lists once the classes are created.

    private boolean loginStatus;
    private List<String> ratingsAndReviews = new ArrayList<>();
    private List<String> watchlist = new ArrayList<>();
    private List<String> preferredGenres;

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
}
