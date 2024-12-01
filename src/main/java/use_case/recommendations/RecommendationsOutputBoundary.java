package use_case.recommendations;

import entity.Movie;
import entity.User;

import java.util.List;

/**
 * The input boundary for the recommendations use case.
 */
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

    /**
     * Refreshes the recommendations.
     */
    void refreshRecommendations();
}
