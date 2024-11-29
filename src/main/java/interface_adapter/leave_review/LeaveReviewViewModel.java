package interface_adapter.leave_review;

import interface_adapter.ViewModel;

/**
 * The view model for the leave a review use case.
 */
public class LeaveReviewViewModel extends ViewModel<Boolean> {

    public LeaveReviewViewModel() {
        super("LeaveReviewsView");
    }

    /**
     * Set the state of the view model to true to indicate success of leaving a review.
     */
    public void success() {
        setState(true);
    }

    /**
     * Set the state of the view model to false, indicate failure of leaving a review.
     */
    public void failure() {
        setState(false);
    }

}
