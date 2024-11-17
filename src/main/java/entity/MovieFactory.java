package entity;

/**
 * Factory for creating movies.
 */
public interface MovieFactory {

    /**
     * Creates a new Movie.
     * @param title the name of the new movie
     * @return the new movie
     */
    Movie create(String title);
}
