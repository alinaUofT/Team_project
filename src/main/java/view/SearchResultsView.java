package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.search_results.SearchResultsController;
import interface_adapter.search_results.SearchResultsViewModel;

/**
 * The View for when the user views a searches for a movie.
 */
public class SearchResultsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Search Results";

    private final SearchResultsViewModel searchResultsViewModel;
    private SearchResultsController searchResultsController;

    private final JButton backButton;
    private final JButton homeButton;
    private final JButton searchButton;

    public SearchResultsView(SearchResultsViewModel searchResultsViewModel) {
        this.searchResultsViewModel = searchResultsViewModel;
        this.searchResultsViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(SearchResultsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.backButton = new JButton(SearchResultsViewModel.BACK_LABEL);
        this.homeButton = new JButton(SearchResultsViewModel.HOME_LABEL);
        this.searchButton = new JButton(SearchResultsViewModel.SEARCH_LABEL);

        final JPanel topButtons = new JPanel();
        topButtons.setLayout(new BorderLayout());
        topButtons.add(backButton, BorderLayout.WEST);
        topButtons.add(homeButton, BorderLayout.EAST);

        // TODO: show search bar - IDK how
        // TODO: show results
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
