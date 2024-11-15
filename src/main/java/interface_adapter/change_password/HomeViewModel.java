package interface_adapter.change_password;

import interface_adapter.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class HomeViewModel extends ViewModel<LoggedInState> {

    public HomeViewModel() {
        super("logged in");
        setState(new LoggedInState());
    }

}