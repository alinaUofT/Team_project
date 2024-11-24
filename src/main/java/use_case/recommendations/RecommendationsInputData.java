package use_case.recommendations;

import java.util.List;

import entity.CommonUser;

/**
 * The Input Data for the Signup Use Case.
 */
public class RecommendationsInputData {
    private final CommonUser user;
    private final List<String> preferredGenres;

    public RecommendationsInputData(CommonUser user) {
        this.user = user;
        this.preferredGenres = user.getPreferredGenres();

    }

    CommonUser getUser() {
        return user;
    }

    List<String> getPreferredGenres() {
        return preferredGenres;
    }
}
