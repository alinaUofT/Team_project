package use_case.my_reviews;

public interface My_ReviewsOutputBoundary {
        void prepareMyReviewsView(MyReviewsOutputData my_reviewsOutputData);
        void goBack();
        void prepareNoReviewsView(String no_reviews_msg);
    }
