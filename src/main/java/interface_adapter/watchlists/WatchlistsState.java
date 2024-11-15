package interface_adapter.watchlists;

import entity.User;

/**
 * The state for the Watchlists View Model.
 */
public class WatchlistsState {
    private User currentUser;
    private String listName;

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public String getListName() {
        return this.listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "WatchlistsState{"
                + "currentUser='" + currentUser
                + "', listName='" + listName
                + '}';
    }
}
