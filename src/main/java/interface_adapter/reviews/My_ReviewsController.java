package interface_adapter.reviews;

import entity.User;
import use_case.my_reviews.My_ReviewsInputBoundary;

public class My_ReviewsController {
    private final My_ReviewsInputBoundary interactor;

    public My_ReviewsController(My_ReviewsInputBoundary interactor) {
        this.interactor = interactor; // Dependency injection of the use case interactor
    }

    public void handleGetReviews(User user) {
        interactor.execute(user); // Calls the use case logic
    }
}
