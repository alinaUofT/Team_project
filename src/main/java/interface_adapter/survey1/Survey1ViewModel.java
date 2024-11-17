package interface_adapter.survey1;

import interface_adapter.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class Survey1ViewModel extends ViewModel<Survey1State> {

    public Survey1ViewModel(String viewName) {
        super("survey step 1");
        setState(new Survey1State());
    }
}
