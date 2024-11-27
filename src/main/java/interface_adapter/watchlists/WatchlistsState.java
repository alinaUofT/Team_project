package interface_adapter.watchlists;

import entity.User;

/**
 * The state for the Watchlists View Model.
 */
public class WatchlistsState {
    private User currentUser;
    private String username;
    private String listError;

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public String getListError() {
        return listError;
    }

    public void setListError(String listError) {
        this.listError = listError;
    }

    @Override
    public String toString() {
        return "WatchlistsState{"
                + "currentUser='" + currentUser.getName()
                + '}';
    }
}
