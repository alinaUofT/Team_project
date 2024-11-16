package entity;

import java.util.List;

/**
 * The representation of a movie in our program.
 */
public interface Movie {

    /**
     * Returns the title of the movie.
     * @return the title of the movie.
     */
    String getTitle();

    /**
     * Returns the star ratings of the movie.
     * @return the star ratings of the movie.
     */
    int getStarRatings();

    /**
     * Returns the reviews of the movie from users.
     * @return the reviews of the movie from users.
     */
    List<String> getUserReviews();

    /**
     * Returns the list of genres of the movie.
     * @return the list of genres of the movie.
     */
    List<String> getGenres();
}
