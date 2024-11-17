package interface_adapter.reviews;

public class My_ReviewsController {
    private final MyReviewsInputBoundary interactor;

    public MyReviewsController(MyReviewsInputBoundary interactor) {
        this.interactor = interactor; // Dependency injection of the use case interactor
    }

    public void handleGetReviews(User user) {
        interactor.execute(user); // Calls the use case logic
    }
}
