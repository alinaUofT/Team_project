package use_case.survey1;

import java.util.List;

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
    public void execute(Survey1InputData survey1InputData, String username) {
        final List<String> selectedGenres = survey1InputData.getSelectedGenres();
        final String genre1 = selectedGenres.get(0);
        final String genre2 = selectedGenres.get(1);
        final String genre3 = selectedGenres.get(2);

        final Survey1OutputData survey1OutputData = new Survey1OutputData(genre1, genre2, genre3);
        final User user = this.userDataAccessObject.get(username);
        user.addPreferredGenres(selectedGenres);
        survey1Presenter.prepareSuccessView(survey1OutputData);
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