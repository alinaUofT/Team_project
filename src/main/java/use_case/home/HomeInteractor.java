package use_case.home;

import data_access.DBUserDataAccessObject;
import entity.User;
import entity.UserFactory;

/**
 * The Change Password Interactor.
 */
public class HomeInteractor implements HomeInputBoundary {
    private final DBUserDataAccessObject userDataAccessObject;
    private final HomeOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public HomeInteractor(DBUserDataAccessObject homeUserDataAccessInterface,
                          HomeOutputBoundary homeOutputBoundary,
                          UserFactory userFactory) {
        this.userDataAccessObject = homeUserDataAccessInterface;
        this.userPresenter = homeOutputBoundary;
        this.userFactory = userFactory;
    }

    /**
     * Executes the Switch to Watchlists View Use Case.
     * @param username username of the currently logged-in user
     */
    @Override
    public void switchToWatchlistsView(String username) {
        final User curentUser = this.userDataAccessObject.get(username);
        this.userPresenter.switchToWatchlistsView(curentUser);
    }

    public User getUser(String username) {
        return userDataAccessObject.get(username);
    }

}
