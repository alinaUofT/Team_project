package data_access;

import java.util.List;

import entity.CommonMovieFactory;
import entity.Movie;
import use_case.movie.MovieUserDataAccessInterface;

/**
 * The DAO for movie data.
 */
public class DBMovieDataAccessObject implements MovieUserDataAccessInterface {

    private static CommonMovieFactory movieFactory = new CommonMovieFactory();

    public DBMovieDataAccessObject(CommonMovieFactory movieFactory) {
        this.movieFactory = movieFactory;
    }

    @Override
    public boolean existsByName(String title) {
        final List<Object> result = APIMovieAccess.formatedSearchedMovies(title);
        return !result.isEmpty();
    }

    @Override
    public Movie getMovieByName(String title) {
        return null;
    }
}
