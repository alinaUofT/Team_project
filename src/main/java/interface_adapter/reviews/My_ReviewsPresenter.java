package interface_adapter.reviews;

import entity.MovieReview;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.HomeViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.my_reviews.My_ReviewsOutputBoundary;
import view.HomeView;
import view.My_ReviewsNoReviewsView;
import view.My_ReviewsReviewsView;
import view.ViewManager;

import javax.sound.midi.VoiceStatus;
import java.util.List;

public class My_ReviewsPresenter implements My_ReviewsOutputBoundary {
    private final My_ReviewsNoReviewsView myReviewsNoReviewsView;
    private final My_ReviewsReviewsView myReviewsReviewsView;
    private final ViewManagerModel viewManagerModel;
    private final HomeViewModel homeViewModel;

    public My_ReviewsPresenter(My_ReviewsNoReviewsView myReviewsNoReviewsView, My_ReviewsReviewsView myReviewsReviewsView,
                               ViewManagerModel viewManagerModel, HomeViewModel homeViewModel) {
        this.myReviewsNoReviewsView = myReviewsNoReviewsView;
        this.myReviewsReviewsView = myReviewsReviewsView;
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;

    }

    public void my_ReviewsReviewsView(List<MovieReview> my_reviews) {
        // If they have at least one review switch to this screen

    }
    public void my_ReviewsNoReviewsView() {
        // If they do not have any reviews switch to this screen
    }

    @Override
    public void switchToHomeView() {

    }
}
