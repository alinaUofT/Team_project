package use_case.watchlists;

/**
 * Output Data for the Signup Use Case.
 */
public class WatchlistsOutputData {

    private final String username;

    private final boolean useCaseFailed;

    public WatchlistsOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
