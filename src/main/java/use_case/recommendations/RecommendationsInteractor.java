package use_case.recommendations;

import entity.Movie;
import entity.User;
import entity.UserFactory;

public class RecommendationsInteractor implements RecommendationsInputBoundary {
    private final RecommendationsUserDataAccessInterface userDataAccessObject;
    private final RecommendationsOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public RecommendationsInteractor(RecommendationsUserDataAccessInterface recommendationsUserDataAccessInterface,
                                     RecommendationsOutputBoundary recommendationsOutputBoundary,
                                UserFactory userFactory) {
        this.userDataAccessObject = recommendationsUserDataAccessInterface;
        this.userPresenter = recommendationsOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void switchToHomeView() {
        userPresenter.switchToHomeView();
    }

    @Override
    public void switchToMovieView(User currentUser, Movie movie) {
        userPresenter.switchToMovieView(currentUser, movie);
    }
}
