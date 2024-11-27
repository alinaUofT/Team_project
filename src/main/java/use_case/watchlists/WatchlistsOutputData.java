package use_case.watchlists;

/**
 * Output Data for the Signup Use Case.
 */
public class WatchlistsOutputData {

    private final String username;

    private final boolean useCaseFailed;

    private String watchlistName;

    public WatchlistsOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.watchlistName = "";
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public String getWatchlistName() {
        return watchlistName;
    }

    public void setWatchlistName(String watchlistName) {
        this.watchlistName = watchlistName;
    }
}
