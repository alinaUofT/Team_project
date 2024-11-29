package interface_adapter.recommendations;

import interface_adapter.ViewModel;

/**
 * The View Model for the Recommendations View.
 */
public class RecommendationsViewModel extends ViewModel<RecommendationsState> {
    public static final String TITLE_LABEL = "Movie Recommendations";
    public static final String HOME_LABEL = "Home";
    public static final String REFRESH_LABEL = "Refresh";

    public RecommendationsViewModel() {
        super("recommendations");
        setState(new RecommendationsState());
    }
}
