package interface_adapter.survey1;

import java.util.ArrayList;
import java.util.List;

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
     * @param username the user who is taking the survey
     * @param selectedGenres the selected genres
     */
    public void execute(String username, List<String> selectedGenres) {
        final Survey1InputData survey1InputData = new Survey1InputData((ArrayList<String>) selectedGenres);
        survey1UseCaseInteractor.execute(survey1InputData, username);
    }

    /**
     * Executes the "switch to SurveySecondPageView" Use Case.
     * @param username username of the currently logged-in user
     */
    public void switchToSurveySecondPageView(String username) {
        this.survey1UseCaseInteractor.switchToSurveySecondPageView(username);
    }
}
