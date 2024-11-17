package entity;

/**
 * Factory for creating CommonMovie objects.
 */
public class CommonMovieFactory implements MovieFactory {

    @Override
    public Movie create(String title) {
        return new CommonMovie(title);
    }
}
