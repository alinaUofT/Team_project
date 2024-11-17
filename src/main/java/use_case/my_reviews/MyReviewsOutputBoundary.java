package use_case.my_reviews;

import entity.MovieReview;

import java.util.List;

public interface MyReviewsOutputBoundary {
    void prepareSuccessView(List<MovieReview> reviews);
    void prepareNoReviewsView(String message);
    void prepareFailView(String errorMessage);
}
