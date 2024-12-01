package use_case.recommendations;

import data_access.APIMovieAccess;
import data_access.GenreMap;
import entity.Movie;
import entity.User;
import entity.UserFactory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Interactor for the Recommendations Use Case.
 */
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
    public void refreshRecommendations(RecommendationsInputData inputData, String username) throws IOException {
        final RecommendationsOutputData outputData = new RecommendationsOutputData();
        final User currentUser = this.userDataAccessObject.get(username);
        final Map<String, Integer> preferredGenres = inputData.getPreferredGenres();

        final List<String> max3Genres = preferredGenres.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        final List<Integer> recommendedGenreIds = new ArrayList<>();
        final GenreMap genreMap = new GenreMap();
        for (Map.Entry<Integer, String> entry : genreMap.entrySet()) {
            final Integer id = entry.getKey();
            final String genre = entry.getValue();
            if (max3Genres.contains(genre)) {
                recommendedGenreIds.add(id);
            }
        }
        final List<Movie> recommended = APIMovieAccess.recommendedMovies(
                recommendedGenreIds.get(0), recommendedGenreIds.get(1), recommendedGenreIds.get(2));
        userPresenter.refreshRecommendations();
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
