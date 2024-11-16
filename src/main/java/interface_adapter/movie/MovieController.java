package interface_adapter.movie;

// import

import use_case.movie.MovieInputBoundary;
import use_case.movie.MovieInputData;

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
     * @param movie the title of the movie
     */
    public void execute(String movie) {
        final MovieInputData movieInputData = new MovieInputData(
                movie);

        movieUseCaseInteractor.execute(movieInputData);
    }
}
