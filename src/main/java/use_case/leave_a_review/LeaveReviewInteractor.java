package use_case.leave_a_review;
import java.util.Date;
import entity.CommonMovieReview;
import entity.CommonMovieReviewFactory;
import entity.MovieReview;
import use_case.my_reviews.My_ReviewsOutputBoundary;

public class LeaveReviewInteractor implements LeaveReviewInputBoundary {
    // This must take the input data provided by the controller and format it into a movie review object
    // that is then passed to the DB access layer along with the User object to store the review associated
    // to said user in our DB.
    private final LeaveReviewDataAccessInterface leaveReviewDataAccessInterface; // handles accessing our DB
    private final LeaveReviewOutputBoundary leaveReviewPresenter; // passes the info to our presenter
    private final CommonMovieReviewFactory commonMovieReviewFactory;
    private Date currentDate = new Date();
    public LeaveReviewInteractor(LeaveReviewDataAccessInterface leaveReviewDataAccessInterface,
                                 LeaveReviewOutputBoundary leaveReviewPresenter) {
        this.leaveReviewDataAccessInterface = leaveReviewDataAccessInterface;
        this.leaveReviewPresenter = leaveReviewPresenter;
        this.commonMovieReviewFactory = new CommonMovieReviewFactory();
    }

    public void execute(String userID, Double stars, String writtenReview, String movieTitle) {
       final MovieReview movieReview = commonMovieReviewFactory.create(userID, currentDate, stars, writtenReview,
                movieTitle);
        leaveReviewDataAccessInterface.leaveReview(movieReview);

    }
    // Overloaded execute method
    public void execute(String userID, Double stars, String movieTitle) {
        final MovieReview movieReview = commonMovieReviewFactory.create(userID, currentDate, stars,
                movieTitle);
        leaveReviewDataAccessInterface.leaveReview(movieReview);
    }

    @Override
    public void goBack() {
        leaveReviewPresenter.goBack();
    }
}
