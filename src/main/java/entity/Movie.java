package entity;

import java.util.List;

/**
 * The representation of a movie in our program.
 */
public interface Movie {

    /**
     * Calls the API to get the information about the movie.
     * @param movieInfo is a list of the information provided by formatedSearchedMovies
     */
    void setInfo(List<Object> movieInfo);

    /**
     * Returns the title of the movie.
     * @return the title of the movie.
     */
    String getTitle();

    /**
     * Returns the poster path of the movie.
     * @return the poster path of the movie.
     */
    String getPoster();

    /**
     * Returns the overview/summary of the movie.
     * @return the overview of the movie.
     */
    String getOverview();

    /**
     * Returns the average voter ratings of the movie.
     * @return the average voter ratings of the movie.
     */
    Double getVoterAverage();

    /**
     * Returns the list of genres of the movie.
     * @return the list of genres of the movie.
     */
    List<String> getGenres();

    /**
     * Returns the star ratings of the movie.
     * @return the star ratings of the movie.
     */
    Double getStarRatings();

    /**
     * Returns the reviews of the movie from users.
     * @return the reviews of the movie from users.
     */
    List<String> getUserReviews();
}
