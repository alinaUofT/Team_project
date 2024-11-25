package use_case.leave_a_review;

import entity.MovieReview;

public interface LeaveReviewInputBoundary {
    void execute(String userID, Double stars, String writtenReview, String movieTitle);
     void execute(String userID, Double stars, String movieTitle);
     void goBack();
}
