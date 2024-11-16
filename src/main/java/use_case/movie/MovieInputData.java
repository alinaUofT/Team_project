package use_case.movie;

/**
 * The Input Data for the Movie Use Case.
 */
public class MovieInputData {

    private final String movie;

    public MovieInputData(String movieTitle) {
        this.movie = movieTitle;
    }

    public String getMovieTitle() {
        return movie;
    }
}
