package use_case.leave_a_review;

import entity.MovieReview;

public interface LeaveReviewDataAccessInterface {
     boolean leaveReview(MovieReview review);
}
