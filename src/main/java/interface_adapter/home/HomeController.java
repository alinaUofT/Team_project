package interface_adapter.home;

import entity.User;
import use_case.home.HomeInputBoundary;

/**
 * Controller for the Home Use Case.
 */
public class HomeController {
    private final HomeInputBoundary homeInteractor;

    public HomeController(HomeInputBoundary homeInteractor) {
        this.homeInteractor = homeInteractor;
    }

    /**
     * Executes the "switch to WatchlistsView" Use Case.
     * @param username of the currently logged in user
     */
    public void switchToWatchlistsView(String username) {
        this.homeInteractor.switchToWatchlistsView(username);
    }

    /**
     * Executes the "switch to RecommendationsView" Use Case.
     * @param username of the currently logged in user
     */
    public void switchToRecommendationsView(String username) {
        this.homeInteractor.switchToRecommendationsView(username);
    }

    public User getUser(String username){
        return homeInteractor.getUser(username);
    }
  
    /**
     * Executes the "switch to Search Results" Use Case.
     * @param query query of the search result
     */
    public void switchToSearchResultsView(String query) {
        this.homeInteractor.switchToSearchResultsView(query);
    }

}
