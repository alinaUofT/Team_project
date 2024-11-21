package entity;

import java.util.Collection;
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
    List<String> getWatchlists();

    /**
     * Returns the preferred genres of the user.
     * @return list of preferred genres of the user.
     */
    List<String> getPreferredGenres();

    /**
     * Add genre to user's preferred genres.
     * @param genre the genre to be added to the user's preferred genres.
     */
    void addPreferredGenre(String genre);
}
