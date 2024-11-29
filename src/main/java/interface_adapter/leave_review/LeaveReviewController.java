package interface_adapter.leave_review;

import use_case.leave_a_review.LeaveReviewInputBoundary;

/**
 * The controller for the leave a review use case.
 */

public class LeaveReviewController {
    private final LeaveReviewInputBoundary leaveReviewInteractor;

    public LeaveReviewController(LeaveReviewInputBoundary leaveReviewInteractor) {
        this.leaveReviewInteractor = leaveReviewInteractor;
    }

    void leaveReview(String userID, Double stars, String writtenReview, String movieTitle) {
        leaveReviewInteractor.execute(userID, stars, writtenReview, movieTitle);
    }

    void leaveReview(String userID, Double stars, String movieTitle) {
        leaveReviewInteractor.execute(userID, stars, movieTitle);
    }

    void goBack() {
        leaveReviewInteractor.goBack();
    }
}
