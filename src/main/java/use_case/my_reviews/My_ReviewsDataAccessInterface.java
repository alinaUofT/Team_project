package use_case.my_reviews;

import entity.MovieReview;
import entity.User;

import java.util.ArrayList;

public interface My_ReviewsDataAccessInterface {
    // Returns an arrayList of MovieReview objects associated to this user.
    ArrayList<MovieReview> getReviews(User user);
}
