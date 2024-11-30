package interface_adapter.movie;

import use_case.movie.MovieInputBoundary;
import use_case.movie.MovieInputData;

import java.util.List;

/**
 * Controller for the Movie Use Case.
 */
public class MovieController {
    private final MovieInputBoundary movieUseCaseInteractor;

    public MovieController(MovieInputBoundary movieUseCaseInteractor) {
        this.movieUseCaseInteractor = movieUseCaseInteractor;
    }

    /**
     * Executes the Movie Use Case.
     * @param movieName the title of the movie
     * @param posterPath the poster path for the movie
     * @param overview the overview of the movie
     * @param voteAverage the average votes of the movie
     * @param genres a list of the movies genres
     */
    public void execute(String movieName, String posterPath,
                        String overview, int voteAverage,
                        List<String> genres) {
        final MovieInputData movieInputData = new MovieInputData(movieName, posterPath,
                overview, voteAverage, genres);

        movieUseCaseInteractor.execute(movieInputData);
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        movieUseCaseInteractor.switchToHomeView();
    }

    public void switchToLeaveReviewView() {
        movieUseCaseInteractor.switchToLeaveReviewView();
    }
}
