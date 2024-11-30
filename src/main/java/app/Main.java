package app;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     * @throws IOException if an error occurs while reading the file
     */
    public static void main(String[] args) throws IOException {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addWatchlistsView()
                                            .addWatchlistView()
                                            .addSurvey1View()
                                            .addMyReviewsView()
                                            .addSurveySecondPageView()
                                            .addRecommendationsView()
                                            .addSearchResultsView()
                                            .addMovieView()

                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addLogoutUseCase()
                                            .addWatchlistsUseCase()
                                            .addWatchlistUseCase()
                                            .addHomeUseCase()
                                            .addLeaveReviewView()
                                            .addLeaveReviewUseCase()
                                            .addCreateWatchlistUseCase()
                                            .addRenameUseCase()
                                            .addMyReviewsUseCase()
                                            .addRecommendationsUseCase()
                                            .addSurvey1UseCase()
                                            .addSurveySecondPageUseCase()
                                            .addSearchResultsUseCase()
                                            .addMovieUseCase()
                                            .build();
        
        application.pack();
        application.setVisible(true);
    }
}
