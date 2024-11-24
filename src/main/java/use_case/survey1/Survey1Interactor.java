package use_case.survey1;

import entity.User;
import entity.UserFactory;

/**
 * The Survey1 Interactor.
 */
public class Survey1Interactor implements Survey1InputBoundary {
    private final Survey1UserDataAccessInterface userDataAccessObject;
    private final Survey1OutputBoundary survey1Presenter;
    private final UserFactory userFactory;

    public Survey1Interactor(Survey1UserDataAccessInterface survey1userDataAccessInterface,
                           Survey1OutputBoundary survey1OutputBoundary,
                             UserFactory userFactory) {
        this.userDataAccessObject = survey1userDataAccessInterface;
        this.survey1Presenter = survey1OutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(Survey1InputData survey1InputData, User user) {
        final String genre1 = survey1InputData.getGenre1();
        final String genre2 = survey1InputData.getGenre2();
        final String genre3 = survey1InputData.getGenre3();

        if (user.getPreferredGenres().isEmpty()) {
            survey1Presenter.prepareFailView("You must select three more genre.");
        }
        else if (user.getPreferredGenres().size() == 1) {
            survey1Presenter.prepareFailView("You must select two more genres.");
        }
        else if (user.getPreferredGenres().size() == 2) {
            survey1Presenter.prepareFailView("You must select one more genre.");
        }
        else if (user.getPreferredGenres().size() == 3) {
            final Survey1OutputData survey1OutputData = new Survey1OutputData(genre1, genre2, genre3);
            survey1Presenter.prepareSuccessView(survey1OutputData);
        }
    }

    /**
     * Executes the switch to Survey Second Page use case.
     */
    @Override
    public void switchToSurveySecondPageView(String username) {
        final User curentUser = this.userDataAccessObject.get(username);
        survey1Presenter.switchToSurveySecondPageView(curentUser);
    }
}
