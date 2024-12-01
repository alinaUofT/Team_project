package interface_adapter.recommendations;

import entity.Movie;
import entity.User;
import use_case.recommendations.RecommendationsInputBoundary;
import use_case.recommendations.RecommendationsInputData;

/**
 * Controller for the Recommendations Use Case.
 */
public class RecommendationsController {
    private final RecommendationsInputBoundary recommendationsInteractor;

    public RecommendationsController(RecommendationsInputBoundary recommendationsInteractor) {
        this.recommendationsInteractor = recommendationsInteractor;
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        recommendationsInteractor.switchToHomeView();
    }

    /**
     * Executes the "switch to RecommendationsView" Use Case.
     *
     * @param currentUser user that is currently logged in
     * @param movie       info to show
     */
    public void switchToMovieView(User currentUser, Movie movie) {
        recommendationsInteractor.switchToMovieView(currentUser, movie);
    }

    /**
     * Executes the "refresh Recommendations" Use Case.
     * @param currentUser user that is currently logged in
     */
    public void refreshRecommendations(User currentUser) {
        final RecommendationsInputData inputData = new RecommendationsInputData(currentUser);
        this.recommendationsInteractor.refreshRecommendations(inputData, currentUser.getName());
    }
}
