package use_case.signup;

/**
 * Input Boundary for actions which are related to signing up.
 */
public interface SignupInputBoundary {

    /**
     * Executes the signup use case.
     * @param signupInputData the input data
     */
    void execute(SignupInputData signupInputData);

    /**
     * Executes the switch to Survey1View use case.
     */
    void switchToSurvey1View();

    /**
     * Executes the switch to LoginView use case.
     */
    void switchToLoginView();
}
