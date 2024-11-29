package interface_adapter.survey1;

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
     * Executes the "submit survey" Use Case.
     * @param selectedGenres the genres selected by the user
     * @param username username of the currently logged-in user
     */
    public void execute(List<String> selectedGenres, String username) {
        final Survey1InputData survey1InputData = new Survey1InputData(selectedGenres);
        this.survey1UseCaseInteractor.execute(survey1InputData, username);
    }

    /**
     * Executes the "switch to SurveySecondPageView" Use Case.
     * @param username username of the currently logged-in user
     * @throws IllegalArgumentException if username is null or empty
     */
    public void switchToSurveySecondPageView(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        else {
            this.survey1UseCaseInteractor.switchToSurveySecondPageView(username);
        }
    }
}
