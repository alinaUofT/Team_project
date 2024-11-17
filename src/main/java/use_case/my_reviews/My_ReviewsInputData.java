package use_case.my_reviews;

import entity.User;

public class My_ReviewsInputData {
    private final User user;

    My_ReviewsInputData(User user) {
        this.user = user;
    }

    String getUser() {
        return this.user.getName();
    }
}
