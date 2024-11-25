package interface_adapter.leave_review;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import use_case.leave_a_review.LeaveReviewOutputBoundary;

public class LeaveReviewPresenter implements LeaveReviewOutputBoundary {
   private final LeaveReviewViewModel viewModel;
   private final ViewManagerModel viewManagerModel;



   public LeaveReviewPresenter(LeaveReviewViewModel viewModel, ViewManagerModel viewManagerModel) {
       this.viewModel = viewModel;
       this.viewManagerModel = viewManagerModel;
   }

   public void goHome() {
        viewManagerModel.setState("logged in");
        viewManagerModel.firePropertyChanged();
   }

    public void goBack() {
        viewManagerModel.setState("Movie Screen (I watched this clicked)"); // Update later?
        viewManagerModel.firePropertyChanged();
    }
    public void success() {
        viewModel.success();
        viewModel.firePropertyChanged();
        viewManagerModel.setState("Leave a review success");
        viewManagerModel.firePropertyChanged();
    }
    public void failure() {
        viewModel.failure();
        viewModel.firePropertyChanged();
        viewManagerModel.setState("Leave a review failure");
        viewManagerModel.firePropertyChanged();
    }
}
