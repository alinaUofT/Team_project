package use_case.my_reviews;

import entity.MovieReview;

import java.util.List;

    public interface My_ReviewsOutputBoundary {
        void prepareMyReviewsView(My_ReviewsOutputData my_reviewsOutputData);
        void goBack();
        void prepareNoReviewsView(String no_reviews_msg);
    }
