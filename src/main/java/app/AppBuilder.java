package app;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.movie.MovieViewModel;
import interface_adapter.recommendations.RecommendationsController;
import interface_adapter.recommendations.RecommendationsPresenter;
import interface_adapter.recommendations.RecommendationsViewModel;
import interface_adapter.reviews.My_ReviewsController;
import interface_adapter.reviews.My_ReviewsPresenter;
import interface_adapter.reviews.My_ReviewsViewModel;
import data_access.DBUserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeController;
import interface_adapter.home.HomePresenter;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.survey1.SubmitController;
import interface_adapter.survey1.Survey1Presenter;
import interface_adapter.survey1.Survey1ViewModel;

import interface_adapter.survey_second_page.SurveySecondPageController;
import interface_adapter.survey_second_page.SurveySecondPagePresenter;
import interface_adapter.survey_second_page.SurveySecondPageViewModel;

import interface_adapter.watchlist.WatchlistController;
import interface_adapter.watchlist.WatchlistPresenter;

import interface_adapter.watchlist.WatchlistViewModel;
import interface_adapter.watchlists.WatchlistsController;
import interface_adapter.watchlists.WatchlistsPresenter;
import interface_adapter.watchlists.WatchlistsViewModel;
import use_case.home.HomeInputBoundary;
import use_case.home.HomeInteractor;
import use_case.home.HomeOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.my_reviews.*;
import use_case.recommendations.RecommendationsInputBoundary;
import use_case.recommendations.RecommendationsInteractor;
import use_case.recommendations.RecommendationsOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;

import use_case.survey1.Survey1InputBoundary;
import use_case.survey1.Survey1Interactor;
import use_case.survey1.Survey1OutputBoundary;
import use_case.survey_second_page.SurveySecondPageInputBoundary;
import use_case.survey_second_page.SurveySecondPageInteractor;
import use_case.survey_second_page.SurveySecondPageOutputBoundary;

import use_case.watchlist.WatchlistInputBoundary;
import use_case.watchlist.WatchlistInteractor;
import use_case.watchlist.WatchlistOutputBoundary;

import use_case.watchlists.WatchlistsInputBoundary;
import use_case.watchlists.WatchlistsInteractor;
import use_case.watchlists.WatchlistsOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final CommonUserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final DBUserDataAccessObject userDataAccessObject = new DBUserDataAccessObject(userFactory);

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoginView loginView;
    private HomeViewModel homeViewModel;
    private HomeView loggedInView;
    private WatchlistsView watchlistsView;
    private WatchlistsViewModel watchlistsViewModel;
    private WatchlistView watchlistView;
    private WatchlistViewModel watchlistViewModel;
    private Survey1View survey1View;
    private Survey1ViewModel survey1ViewModel;
    private My_ReviewsViewModel my_ReviewsViewModel;
    private My_ReviewsView my_ReviewsView;
    private RecommendationsViewModel recommendationsViewModel;
    private RecommendationsView recommendationsView;
    private MovieViewModel movieViewModel;
    private SurveySecondPageViewModel surveySecondPageViewModel;
    private SurveySecondPageView surveySecondPageView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        homeViewModel = new HomeViewModel();
        loggedInView = new HomeView(homeViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the Watchlists View to the application.
     * @return this builder
     */
    public AppBuilder addWatchlistsView() {
        watchlistsViewModel = new WatchlistsViewModel();
        watchlistsView = new WatchlistsView(watchlistsViewModel);
        cardPanel.add(watchlistsView, watchlistsView.getViewName());
        return this;
    }

    /**
     * Adds the Watchlists View to the application.
     * @return this builder
     */
    public AppBuilder addWatchlistView() {
        watchlistViewModel = new WatchlistViewModel();
        watchlistView = new WatchlistView(watchlistViewModel);
        cardPanel.add(watchlistView, watchlistView.getViewName());
        return this;
    }

    /**
     * Adds the MyReviews View to the application.
     * @return this builder
     */
    public AppBuilder addMyReviewsView() {
        // Step 1: Initialize the ViewModel
        my_ReviewsViewModel = new My_ReviewsViewModel();

        // Step 2: Initialize the View and link it to the ViewModel
        my_ReviewsView = new My_ReviewsView(my_ReviewsViewModel);

        // Step 3: Add the View to the CardPanel with its unique name
        cardPanel.add(my_ReviewsView, my_ReviewsView.getViewName());

        // Step 4: Return the AppBuilder for chaining
        return this;
    }

    /**
     * Adds the Survey1 View to the application.
     * @return this builder
     */
    public AppBuilder addRecommendationsView() {
        recommendationsViewModel = new RecommendationsViewModel();
        recommendationsView = new RecommendationsView(recommendationsViewModel);
        cardPanel.add(recommendationsView, recommendationsView.getViewName());
        return this;
    }

    /**
     * Adds the My_Reviews Use Case to the application.
     * @return this builder
     */
    public AppBuilder addMy_ReviewsUseCase() {

        //   Create the Presenter and link it to the ViewModel
        final My_ReviewsOutputBoundary my_ReviewsOutputBoundary =
                new My_ReviewsPresenter(my_ReviewsViewModel, viewManagerModel);

        //  Create the Interactor
        final My_ReviewsInputBoundary my_ReviewsInteractor = new My_ReviewsInteractor(
                userDataAccessObject,
                my_ReviewsOutputBoundary
        );

        // Create the Controller
        final My_ReviewsController myReviewsController = new My_ReviewsController(my_ReviewsInteractor);

        loggedInView.setMyReviewsController(myReviewsController);
        my_ReviewsView.setMyReviewsController(myReviewsController);
        // Return
        return this;
    }

    /**
     * Adds the Survey1 View to the application.
     * @return this builder
     * @throws IOException checkstyle
     */
    public AppBuilder addSurvey1View() throws IOException {
        survey1ViewModel = new Survey1ViewModel();
        survey1View = new Survey1View(survey1ViewModel);
        cardPanel.add(survey1View, survey1View.getViewName());
        return this;
    }

    /**
     * Adds the Survey1 View to the application.
     * @return this builder
     * @throws IOException checkstyle
     */
    public AppBuilder addSurveySecondPageView() throws IOException {
        surveySecondPageViewModel = new SurveySecondPageViewModel();
        surveySecondPageView = new SurveySecondPageView(surveySecondPageViewModel);
        cardPanel.add(surveySecondPageView, surveySecondPageView.getViewName());
        return this;
    }

    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel, homeViewModel, survey1ViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                homeViewModel, loginViewModel, signupViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

//    /**
//     * Adds the Change Password Use Case to the application.
//     * @return this builder
//     */
//    public AppBuilder addChangePasswordUseCase() {
//        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
//                new ChangePasswordPresenter(homeViewModel);
//
//        final ChangePasswordInputBoundary changePasswordInteractor =
//                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);
//
//        final ChangePasswordController changePasswordController =
//                new ChangePasswordController(changePasswordInteractor);
//        loggedInView.setChangePasswordController(changePasswordController);
//        return this;
//    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                homeViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Adds the Watchlists Use Case to the application.
     * @return this builder
     */
    public AppBuilder addWatchlistsUseCase() {
        final WatchlistsOutputBoundary watchlistsOutputBoundary = new WatchlistsPresenter(viewManagerModel,
                watchlistsViewModel, homeViewModel, watchlistViewModel);
        final WatchlistsInputBoundary watchlistsInteractor = new WatchlistsInteractor(
                userDataAccessObject, watchlistsOutputBoundary, userFactory);

        final WatchlistsController controller = new WatchlistsController(watchlistsInteractor);
        watchlistsView.setWatchlistsController(controller);
        return this;
    }

    /**
     * Adds the Watchlist Use Case to the application.
     * @return this builder
     */
    public AppBuilder addWatchlistUseCase() {
        final WatchlistOutputBoundary watchlistOutputBoundary = new WatchlistPresenter(viewManagerModel,
                watchlistsViewModel, homeViewModel, watchlistViewModel);
        final WatchlistInputBoundary watchlistInteractor = new WatchlistInteractor(
                userDataAccessObject, watchlistOutputBoundary, userFactory);

        final WatchlistController controller = new WatchlistController(watchlistInteractor);
        watchlistView.setWatchlistController(controller);
        return this;
    }

    /**
     * Adds the Home Use Case to the application.
     * @return this builder
     */
    public AppBuilder addHomeUseCase() {
        final HomeOutputBoundary homeOutputBoundary = new HomePresenter(viewManagerModel,
                watchlistsViewModel, recommendationsViewModel, homeViewModel);
        final HomeInputBoundary homeInteractor = new HomeInteractor(
                userDataAccessObject, homeOutputBoundary, userFactory);

        final HomeController controller = new HomeController(homeInteractor);
        loggedInView.setHomeController(controller);
        return this;
    }

    /**
     * Adds the Recommendations Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecommendationsUseCase() {
        final RecommendationsOutputBoundary recommendationsOutputBoundary = new RecommendationsPresenter(
                viewManagerModel, recommendationsViewModel, movieViewModel, homeViewModel);
        final RecommendationsInputBoundary recommendationsInteractor = new RecommendationsInteractor(
                userDataAccessObject, recommendationsOutputBoundary, userFactory);

        final RecommendationsController controller = new RecommendationsController(recommendationsInteractor);
        recommendationsView.setRecommendationsController(controller);
        return this;
    }

    /**
     * Adds the Survey1 Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSurvey1UseCase() {
        final Survey1OutputBoundary survey1OutputBoundary = new Survey1Presenter(
                survey1ViewModel, surveySecondPageViewModel, viewManagerModel);
        final Survey1InputBoundary survey1Interactor = new Survey1Interactor(
                userDataAccessObject, survey1OutputBoundary, userFactory);

        // Create the Controller
        final SubmitController submitController = new SubmitController(survey1Interactor);

        // Link the Controller to the View
        survey1View.setSubmitController(submitController);

        // Return the AppBuilder for chaining
        return this;
    }

    /**
     * Adds the Survey Second Page Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSurveySecondPageUseCase() {
        final SurveySecondPageOutputBoundary surveySecondPageOutputBoundary = new SurveySecondPagePresenter(
                viewManagerModel, surveySecondPageViewModel, homeViewModel);
        final SurveySecondPageInputBoundary surveySecondPageInteractor = new SurveySecondPageInteractor(
                userDataAccessObject, surveySecondPageOutputBoundary, userFactory);
        final SurveySecondPageController surveySecondPageController =
                new SurveySecondPageController(surveySecondPageInteractor);
        surveySecondPageView.setSurveySecondPageController(surveySecondPageController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Movies4U");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}