package use_case.watchlists;

import entity.User;

/**
 * DAO for the Signup Use Case.
 */
public interface WatchlistsUserDataAccessInterface {

    /**
     * Checks if the given username exists.
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String username);

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);
}
