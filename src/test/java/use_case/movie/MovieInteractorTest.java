package use_case.movie;

import data_access.APIMovieAccess;
import data_access.DBMovieDataAccessObject;
import entity.CommonMovie;
import entity.CommonMovieFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieInteractorTest {

    @Test
    void successTest(){
        final CommonMovieFactory movieFactory = new CommonMovieFactory();
        MovieUserDataAccessInterface movieDataAccessInterface = new DBMovieDataAccessObject(movieFactory);

        final String movieTitle = "Home Alone";
        final List<CommonMovie> results = APIMovieAccess.formatedSearchedMovies(movieTitle);

        MovieInputData movieInputData = new MovieInputData(movieTitle, results);

        MovieOutputBoundary moviePresenter = new MovieOutputBoundary() {
            @Override
            public void prepareSuccessView(MovieOutputData movieOutputData) {
                // This method should be called in the test case.
            }

            @Override
            public void switchToHomeView() {
                fail("switchToHomeView is not the method that should be called");
            }

            @Override
            public void switchToLeaveReviewView() {
                fail("switchToLeaveReviewView is not the method that should be called");
            }
        };

        MovieInputBoundary interactor = new MovieInteractor(movieDataAccessInterface, moviePresenter);
        interactor.execute(movieInputData);
    }

    @Test
    void switchToHomeViewTest(){
        final CommonMovieFactory movieFactory = new CommonMovieFactory();
        MovieUserDataAccessInterface movieDataAccessInterface = new DBMovieDataAccessObject(movieFactory);

        MovieOutputBoundary moviePresenter = new MovieOutputBoundary() {
            @Override
            public void prepareSuccessView(MovieOutputData movieOutputData) {
                fail("prepareSuccessView is not the method that should be called");
            }

            @Override
            public void switchToHomeView() {
                // This method should be called in the test case.
            }

            @Override
            public void switchToLeaveReviewView() {
                fail("switchToLeaveReviewView is not the method that should be called");
            }
        };

        MovieInputBoundary interactor = new MovieInteractor(movieDataAccessInterface, moviePresenter);
        interactor.switchToHomeView();
    }

    @Test
    void switchToLeaveReviewViewTest(){
        final CommonMovieFactory movieFactory = new CommonMovieFactory();
        MovieUserDataAccessInterface movieDataAccessInterface = new DBMovieDataAccessObject(movieFactory);

        MovieOutputBoundary moviePresenter = new MovieOutputBoundary() {
            @Override
            public void prepareSuccessView(MovieOutputData movieOutputData) {
                fail("prepareSuccessView is not the method that should be called");
            }

            @Override
            public void switchToHomeView() {
                fail("switchToHomeView is not the method that should be called");
            }

            @Override
            public void switchToLeaveReviewView() {
                // This method should be called in the test case.

            }
        };

        MovieInputBoundary interactor = new MovieInteractor(movieDataAccessInterface, moviePresenter);
        interactor.switchToLeaveReviewView();
    }

}
