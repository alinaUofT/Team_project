package interface_adapter.survey1;

import entity.User;
import use_case.survey1.Survey1InputBoundary;
import use_case.survey1.Survey1InputData;

/**
 * The controller for the Login Use Case.
 */
public class SubmitController {
    private final Survey1InputBoundary survey1UseCaseInteractor;

    public SubmitController(Survey1InputBoundary survey1UseCaseInteractor) {
        this.survey1UseCaseInteractor = survey1UseCaseInteractor;
    }

    /**
     * Executes the Survey1 Use Case.
     * @param user the user who is taking the survey
     * @param genre1 the first movie genre that the user selects
     * @param genre2 the second movie genre that the user selects
     * @param genre3 the third movie genre that the user selects
     */
    public void execute(User user, String genre1, String genre2, String genre3) {
        final Survey1InputData survey1InputData = new Survey1InputData(genre1, genre2, genre3);
        user.addPreferredGenres(genre1);
        user.addPreferredGenres(genre2);
        user.addPreferredGenres(genre3);
        survey1UseCaseInteractor.execute(survey1InputData, user);
    }

    /**
     * Executes the "switch to SurveySecondPageView" Use Case.
     * @param username username of the currently logged-in user
     */
    public void switchToSurveySecondPageView(String username) {
        this.survey1UseCaseInteractor.switchToSurveySecondPageView(username);
    }
}
