package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;

import entity.*;
import interface_adapter.add_to_watchlist.AddToWatchlistController;
import interface_adapter.movie.MovieController;
import interface_adapter.movie.MovieState;
import interface_adapter.movie.MovieViewModel;

/**
 * The View for when the user views a movie.
 */
public class MovieView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Movie Information";

    private final MovieViewModel movieViewModel;
    private MovieController movieController;

    private AddToWatchlistController addToWatchlistController;

    private final JButton backButton;
    private final JButton homeButton;
    private final JButton watchedButton;
    private final JButton addToListButton;
    private final JButton userReviewsButton;

    public MovieView(MovieViewModel movieViewModel) {
        this.movieViewModel = movieViewModel;
        this.movieViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(MovieViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.backButton = new JButton(MovieViewModel.BACK_LABEL);
        this.homeButton = new JButton(MovieViewModel.HOME_LABEL);

        final JPanel topButtons = new JPanel();
        topButtons.setLayout(new BorderLayout());
        topButtons.add(backButton, BorderLayout.WEST);
        topButtons.add(homeButton, BorderLayout.EAST);

        // TODO: show info about movie via API via label - IDK how

        this.watchedButton = new JButton(MovieViewModel.PWL_LABEL);
        this.addToListButton = new JButton(MovieViewModel.ADD_TO_LIST_LABEL);
        this.userReviewsButton = new JButton(MovieViewModel.USER_REVIEWS_LABEL);

        final JPanel bottomButtons = new JPanel();
        bottomButtons.add(watchedButton);
        bottomButtons.add(addToListButton);
        bottomButtons.add(userReviewsButton);

        watchedButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(watchedButton)) {
                            final MovieState currentState = movieViewModel.getState();
                            final User currUser = currentState.getCurrentUser();

                            final Watchlist pwl = currUser.getPwl();

                            final String movieTitle = currentState.getCurrentMovie().getTitle();

                            addToWatchlistController.execute(currUser, pwl, movieTitle);
                            watchedButton.setText(MovieViewModel.LEAVE_REVIEW_LABEL);
                            for (ActionListener al : watchedButton.getActionListeners()) {
                                watchedButton.removeActionListener(al);
                            }
                            watchedButton.addActionListener(
                                    new ActionListener() {
                                        public void actionPerformed(ActionEvent evt) {
                                            if (evt.getSource().equals(watchedButton)) {
                                                // TODO: execute leave review use case (Wyatt)
                                                // it will probably be too many lines when you implement this which isn't allowed
                                                // you might need to create a helper function
                                            }
                                        }
                                    }
                            );
                        }
                    }
                }
        );

        addToListButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addToListButton)) {
                            addToListPopUpView();
                        }
                    }
                }
        );
    }

    /**
     * View for Add to List Pop-Up Window.
     */
    private void addToListPopUpView() {
        final JPanel panel = new JPanel(new BorderLayout());

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        final MovieState currentState = movieViewModel.getState();

        final ArrayList<UserWatchlist> watchlists = currentState.getCurrentUser().getWatchlists();

        for (UserWatchlist watchlist : watchlists) {
            final String listName = watchlist.getListName();
            final JButton listButton = new JButton(listName);
            final Movie currentMovie = currentState.getCurrentMovie();

            if (watchlist.contains(currentMovie)) {
                listButton.setEnabled(false);
            }
            else {
                listButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(listButton)) {

                            final MovieState currentState = movieViewModel.getState();
                            final User currUser = currentState.getCurrentUser();

                            addToWatchlistController.execute(currUser, watchlist, currentMovie.getTitle());

                            listButton.setEnabled(false);
                        }
                    }
                });
            }

            buttonPanel.add(listButton);
        }

        // create Close button
        final JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(closeButton)) {
                    SwingUtilities.getWindowAncestor(closeButton).dispose();
                }
            }
        });

        // Add items to panel
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);

        JOptionPane.showOptionDialog(this, panel, "My Lists", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{}, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }

    public void setAddToWatchlistController(AddToWatchlistController addToWatchlistController) {
        this.addToWatchlistController = addToWatchlistController;
    }
}
