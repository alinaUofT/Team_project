package use_case.recommendations;

import java.util.List;

import entity.Movie;

public class RecommendationsOutputData {
    private final String username;

    private final List<Movie> recommendedMovies;

    private final boolean useCaseFailed;

    public RecommendationsOutputData(String username, List<Movie> recommendedMovies, boolean useCaseFailed) {
        this.username = username;
        this.recommendedMovies = recommendedMovies;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public List<Movie> getRecommendedMovies() {
        return recommendedMovies;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
