package use_case.recommendations;

import entity.Movie;
import entity.User;

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

}
