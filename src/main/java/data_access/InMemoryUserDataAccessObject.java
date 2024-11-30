package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.User;
import entity.Watchlist;
import use_case.home.HomeUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import use_case.survey1.Survey1UserDataAccessInterface;
import use_case.watchlists.WatchlistsUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        HomeUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        WatchlistsUserDataAccessInterface,
        Survey1UserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    private String currentUsername;

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public boolean savePreferredGenres(User user, Map<String, Integer> preferredGenres) {
        if (user == null || preferredGenres == null) {
            System.out.println("InMemoryUserDataAccessObject: User or preferredGenres is null.");
            return false;
        }

        // Update the user's preferredGenres
        try {
            System.out.println("InMemoryUserDataAccessObject: Saving preferred genres for user: " + user.getName());
            System.out.println("Preferred genres: " + preferredGenres);

            // Iterate over the preferredGenres map and update the user's genres
            for (Map.Entry<String, Integer> entry : preferredGenres.entrySet()) {
                String genre = entry.getKey();
                int count = entry.getValue();

                // Increment the genre count using the user's addPreferredGenres method
                for (int i = 0; i < count; i++) {
                    user.addPreferredGenres(genre);
                }
            }

            // Reflect the changes in the in-memory user repository
            users.put(user.getName(), user);

            System.out.println("Preferred genres saved successfully for user: " + user.getName());
            return true;
        } catch (Exception e) {
            System.err.println("InMemoryUserDataAccessObject: Error saving preferred genres: " + e.getMessage());
            return false;
        }
    }

//    @Override
//    public void changePassword(User user) {
//        // Replace the old entry with the new password
//        users.put(user.getName(), user);
//    }

    @Override
    public void setCurrentUsername(String name) {
        this.currentUsername = name;
    }

    @Override
    public String getCurrentUsername() {
        return this.currentUsername;
    }

    @Override
    public ArrayList<Watchlist> getWatchlists(User user) {
        return user.getWatchlists();
    }
}
