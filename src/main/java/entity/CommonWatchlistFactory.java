package entity;

public class CommonWatchlistFactory {

    public UserWatchlist create(String listName) {
        return new CommonUserWatchlist(listName);
    }
}
