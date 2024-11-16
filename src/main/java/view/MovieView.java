package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.movie.MovieController;
import interface_adapter.movie.MovieViewModel;

/**
 * The View for when the user views a movie.
 */
public class MovieView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Movie Information";

    private final MovieViewModel movieViewModel;
    private MovieController movieController;

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

        // TODO: add listeners here for the above buttons
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
