package use_case.movie;

/**
 * The Movie Interactor.
 */
public class MovieInputInteractor implements MovieInputBoundary {
    private MovieInputBoundary movieInputBoundary;

    public MovieInputInteractor(MovieInputBoundary movieInputBoundary) {
        this.movieInputBoundary = movieInputBoundary;
    }

    @Override
    public void execute(MovieInputData movieInputData) {
        // TODO: Finish this
    }
}
