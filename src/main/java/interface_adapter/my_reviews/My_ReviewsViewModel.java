package interface_adapter.my_reviews;

import interface_adapter.ViewModel;

import java.util.List;

public class My_ReviewsViewModel extends ViewModel<List<String>> {
    private List<String> reviews;

    public My_ReviewsViewModel() {
        super("My_ReviewsView");
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }


}
