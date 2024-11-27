package use_case.recommendations;

import java.util.List;
import java.util.Map;

import entity.CommonUser;

/**
 * The Input Data for the Signup Use Case.
 */
public class RecommendationsInputData {
    private final CommonUser user;
    private final Map<String, Integer> preferredGenres;

    public RecommendationsInputData(CommonUser user) {
        this.user = user;
        this.preferredGenres = user.getPreferredGenres();

    }

    CommonUser getUser() {
        return user;
    }

    Map<String, Integer> getPreferredGenres() {
        return preferredGenres;
    }
}
