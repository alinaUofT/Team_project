package interface_adapter.watchlists;

import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.HomeViewModel;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import use_case.watchlists.WatchlistsOutputBoundary;

/**
 * The Presenter for the Signup Use Case.
 */
public class WatchlistsPresenter implements WatchlistsOutputBoundary {

    private final WatchlistsViewModel signupViewModel;
    private final HomeViewModel homeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;

    public WatchlistsPresenter(ViewManagerModel viewManagerModel,
                               WatchlistsViewModel signupViewModel,
                               LoginViewModel loginViewModel, HomeViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.homeViewModel = new HomeViewModel();
        this.loginViewModel = loginViewModel;

    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the Watchlist View.
     *
     * @param currentUser user that is currently logged in
     * @param ind         index that corresponds to the watchlist to switch to
     */
    @Override
    public void switchToWatchlistView(User currentUser, int ind) {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the PWL View.
     *
     * @param currentUser user that is currently logged in
     */
    @Override
    public void switchToPWLView(User currentUser) {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
