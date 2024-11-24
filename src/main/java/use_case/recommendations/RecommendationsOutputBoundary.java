package use_case.recommendations;

import entity.Movie;
import entity.User;

public interface RecommendationsOutputBoundary {
    /**
     * Switches to the Logged In View.
     */
    void switchToHomeView();

    /**
     * Switches to the PrWatched View.
     * @param currentUser user that is currently logged in
     * @param movie movie information access
     */
    void switchToMovieView(User currentUser, Movie movie);
}
