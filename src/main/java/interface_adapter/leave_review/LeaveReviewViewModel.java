package interface_adapter.leave_review;

import interface_adapter.ViewModel;

public class LeaveReviewViewModel extends ViewModel<Boolean> {


    public LeaveReviewViewModel() {
        super("LeaveReviewsView");
    }

    public void success() {
        setState(true);
    }

    public void failure() {
        setState(false);
    }




}
