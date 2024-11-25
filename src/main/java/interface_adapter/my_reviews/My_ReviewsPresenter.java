package interface_adapter.my_reviews;

import interface_adapter.ViewManagerModel;
import use_case.my_reviews.My_ReviewsOutputBoundary;
import use_case.my_reviews.My_ReviewsOutputData;

import java.util.List;
import java.util.stream.Collectors;

public class My_ReviewsPresenter implements My_ReviewsOutputBoundary {
    private final My_ReviewsViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public My_ReviewsPresenter(My_ReviewsViewModel viewModel,
                               ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareMyReviewsView(My_ReviewsOutputData reviews) {
        // Format each review into a separate string
        List<String> formattedReviews = reviews.getReviews().stream()
                .map(review -> {
                    StringBuilder reviewString = new StringBuilder();
                    reviewString.append("- Title: ").append(review.getMovie_Title()).append("\n")
                            .append("  Date: ").append(review.getDate()).append("\n")
                            .append("  Stars: ").append(review.getStarRating()).append("\n");
                    if (review.getContent() != null) {
                        reviewString.append("  Review: ").append(review.getContent()).append("\n");
                    }
                    reviewString.append("-----------------------------------\n");
                    return reviewString.toString();
                })
                .collect(Collectors.toList());


        // Update the ViewModel with formatted reviews
        // Update the view manager to switch to the reviews view
        viewModel.setState(formattedReviews);
        viewModel.firePropertyChanged();

        this.viewManagerModel.setState(viewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();


    }

    public void goBack() {
        viewManagerModel.setState("logged in");
        viewManagerModel.firePropertyChanged();

    }
    @Override
    public void prepareNoReviewsView(String message) {
        viewModel.setState(null);
        viewModel.firePropertyChanged();
        this.viewManagerModel.setState(viewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
