package use_case.movie;

import java.util.List;

/**
 * The Input Data for the Movie Use Case.
 */
public class MovieInputData {

    private final String movieName;
    private final String posterPath;
    private final String overview;
    private final int voteAverage;
    private final List<String> genres;

    public MovieInputData(String movieName, String posterPath,
                          String overview, int voteAverage,
                          List<String> genres) {

        this.movieName = movieName;
        this.posterPath = posterPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.genres = genres;
    }

    public String getMovieTitle() {
        return movieName;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public List<String> getGenres() {
        return genres;
    }
}
