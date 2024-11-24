package interface_adapter.recommendations;

import java.util.ArrayList;

import entity.Movie;
import entity.User;

/**
 * The state for the Recommendations View Model.
 */
public class RecommendationsState {
    private User currentUser;
    private ArrayList<Movie> recommendedMovies;

    public RecommendationsState() {

    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public ArrayList<Movie> getRecommendedMovies() {
        return this.recommendedMovies;
    }

    public void setRecommendedMovies(ArrayList<Movie> movies) {
        this.recommendedMovies = movies;
    }

    @Override
    public String toString() {
        return "RecommendationsState{"
                + "currentUser='" + currentUser
                + "', recommendedMovies='" + recommendedMovies
                + '}';
    }
}
