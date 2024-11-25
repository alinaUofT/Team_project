package interface_adapter.survey1;

import use_case.survey1.Survey1InputBoundary;

/**
 * The controller for the Login Use Case.
 */
public class SubmitController {
    private final Survey1InputBoundary survey1UseCaseInteractor;

    public SubmitController(Survey1InputBoundary survey1UseCaseInteractor) {

        this.survey1UseCaseInteractor = survey1UseCaseInteractor;
    }

    /**
     * Executes the "switch to SurveySecondPageView" Use Case.
     * @param username username of the currently logged-in user
     */
    public void switchToSurveySecondPageView(String username) {
        this.survey1UseCaseInteractor.switchToSurveySecondPageView(username);
    }
}
