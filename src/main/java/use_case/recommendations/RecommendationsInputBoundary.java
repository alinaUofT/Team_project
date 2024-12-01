package use_case.recommendations;

import entity.Movie;
import entity.User;

/**
 * The input boundary for the recommendations use case.
 */
public interface RecommendationsInputBoundary {
    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();

    /**
     * Executes the switch to watchlist view use case.
     * @param currentUser user that is currently logged in
     * @param movie movie information to show
     */
    void switchToMovieView(User currentUser, Movie movie);

    /**
     * Executes the refresh recommendations use case.
     * @param inputData input data for the use case
     * @param username username of the currently logged-in user
     */
    void refreshRecommendations(RecommendationsInputData inputData, String username);
}
