package use_case.my_reviews;

import entity.MovieReview;

import java.util.List;

public interface My_ReviewsOutputBoundary {
    void prepareMyReviewsView(List<MovieReview> reviews);
    void prepareNoReviewsView(String message);
}
