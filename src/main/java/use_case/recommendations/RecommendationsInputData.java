package use_case.recommendations;

import java.util.Map;

import entity.User;

/**
 * The Input Data for the Signup Use Case.
 */
public class RecommendationsInputData {
    private final User user;
    private final Map<String, Integer> preferredGenres;

    public RecommendationsInputData(User user) {
        this.user = user;
        this.preferredGenres = user.getPreferredGenres();
    }

    /**
     * Gets the preferred genres of the user.
     *
     * @return a map of preferred genres with their corresponding weights
     */
    public Map<String, Integer> getPreferredGenres() {
        return preferredGenres;
    }
}
