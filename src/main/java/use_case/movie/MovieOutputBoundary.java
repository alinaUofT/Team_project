package use_case.movie;

/**
 * The output boundary for the Movie Use Case.
 */
public interface MovieOutputBoundary {

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();

    /**
     * Switches to the User Reviews View.
     */
    void switchToUserReviewsView();
}
