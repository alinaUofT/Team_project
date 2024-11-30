package use_case.movie;

import entity.Movie;

import java.util.List;

/**
 * The Movie Interactor.
 */
public class MovieInteractor implements MovieInputBoundary {
    private final MovieUserDataAccessInterface movieDataAccessObject;
    private final MovieOutputBoundary moviePresenter;

    public MovieInteractor(MovieUserDataAccessInterface movieDataAccessInterface,
                                MovieOutputBoundary movieOutputBoundary) {
        this.movieDataAccessObject = movieDataAccessInterface;
        this.moviePresenter = movieOutputBoundary;
    }

    @Override
    public void execute(MovieInputData movieInputData) {
        final String movieTitle = movieInputData.getMovieTitle();
        final String posterPath = movieInputData.getPosterPath();
        final String overview = movieInputData.getOverview();
        final int voteAverage = movieInputData.getVoteAverage();
        final List<String> genres = movieInputData.getGenres();

        final MovieOutputData movieOutputData = new MovieOutputData(movieTitle,
                posterPath, overview, voteAverage, genres);
        // moviePresenter.switchToMovieView(movieOutputData);
        moviePresenter.switchToMovieView();
    }

    @Override
    public void switchToHomeView() {
//        moviePresenter.switchToHomeView();
    }
}
