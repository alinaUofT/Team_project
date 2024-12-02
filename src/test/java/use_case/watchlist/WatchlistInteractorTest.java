package use_case.watchlist;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUser;
import entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistInteractorTest {

    @Test
    void switchToHomeViewTest() {
        WatchlistUserDataAccessInterface dataAccess = new InMemoryUserDataAccessObject();
        WatchlistOutputBoundary homeViewPresenter = new WatchlistOutputBoundary() {

            @Override
            public void switchToHomeView() {
                // This method should be called in the test case.
            }

            @Override
            public void switchToWatchlistsView(User currentUser) {
                fail("switchToWatchlistsView is not the method that should be called");
            }

            @Override
            public void switchToMovieSearchView(String currentUser) {
                fail("switchToMovieSearchView is not the method that should be called");
            }
        };

        WatchlistInputBoundary interactor = new WatchlistInteractor(dataAccess, homeViewPresenter);
        interactor.switchToHomeView();
    }

    @Test
    void switchToWatchlistsView() {
        WatchlistUserDataAccessInterface dataAccess = new InMemoryUserDataAccessObject();
        dataAccess.save(new CommonUser("Alice", "pwd"));

        WatchlistOutputBoundary watchlistsViewPresenter = new WatchlistOutputBoundary() {

            @Override
            public void switchToHomeView() {
                fail("switchToHomeView is not the method that should be called");
            }

            @Override
            public void switchToWatchlistsView(User currentUser) {
                assertEquals("Alice", currentUser.getName());
            }

            @Override
            public void switchToMovieSearchView(String currentUser) {
                fail("switchToMovieSearchView is not the method that should be called");
            }
        };

        WatchlistInputBoundary interactor = new WatchlistInteractor(dataAccess, watchlistsViewPresenter);
        interactor.switchToWatchlistsView("Alice");
    }

    @Test
    void switchToMovieSearchView() {
        WatchlistUserDataAccessInterface dataAccess = new InMemoryUserDataAccessObject();
        dataAccess.save(new CommonUser("Alice", "pwd"));

        WatchlistOutputBoundary movieSearchPresenter = new WatchlistOutputBoundary() {

            @Override
            public void switchToHomeView() {
                fail("switchToHomeView is not the method that should be called");
            }

            @Override
            public void switchToWatchlistsView(User currentUser) {
                fail("switchToWatchlistsView is not the method that should be called");
            }

            @Override
            public void switchToMovieSearchView(String currentUser) {
                assertEquals("Alice", currentUser);
            }
        };

        WatchlistInputBoundary interactor = new WatchlistInteractor(dataAccess, movieSearchPresenter);
        interactor.switchToMovieSearchView("Alice");
    }
}
