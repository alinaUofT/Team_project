package use_case.my_reviews;

import entity.User;
import use_case.signup.SignupInputData;

public interface My_ReviewsInputBoundary {

    // Find the reviews corresponding to this user
    void execute(User user);

}
