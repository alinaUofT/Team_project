package use_case.survey1;

import entity.User;

/**
 * Input Boundary for actions which are related to first step of survey.
 */
public interface Survey1InputBoundary {

    /**
     * Executes the Survey1 use case.
     * @param survey1InputData the input data
     * @param user the user who is taking the survey
     */
    void execute(Survey1InputData survey1InputData, User user);

    /**
     * Executes the switch to SurveySecondPageView use case.
     * @param username username of the currently logged-in user
     */
    void switchToSurveySecondPageView(String username);
}
