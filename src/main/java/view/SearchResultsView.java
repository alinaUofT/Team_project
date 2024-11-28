package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import entity.CommonMovie;
import interface_adapter.login.LoginState;
import interface_adapter.search_results.SearchResultsController;
import interface_adapter.search_results.SearchResultsState;
import interface_adapter.search_results.SearchResultsViewModel;

/**
 * The View for when the user views a searches for a movie.
 */
public class SearchResultsView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Search Results";

    private final SearchResultsViewModel searchResultsViewModel;
    private SearchResultsController searchResultsController;

    private final JButton home;
    private final JButton enter;

    private final JPanel results;

    private final JTextField searchInputField = new JTextField(50);
    private final JLabel searchResultsErrorField = new JLabel();

    public SearchResultsView(SearchResultsViewModel searchResultsViewModel) {
        this.searchResultsViewModel = searchResultsViewModel;

        // Register as an observer
        this.searchResultsViewModel.addPropertyChangeListener(this);

        // Set the main layout to BorderLayout
        this.setLayout(new BorderLayout());

        // creates the home button and its functionality
        this.home = new JButton(SearchResultsViewModel.HOME_LABEL);
        home.addActionListener(
                evt -> searchResultsController.switchToHomeView()
        );

        // Home button panel on the left
        final JPanel homeButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        homeButton.add(home);
        this.add(homeButton, BorderLayout.WEST);

        // create title on centre top
        final JLabel title = new JLabel(searchResultsViewModel.TITLE_LABEL);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        // creates the enter button
        this.enter = new JButton(SearchResultsViewModel.ENTER_LABEL);
        enter.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(enter)) {
                        final String query = searchInputField.getText();
                        this.searchResultsController.execute(query);
                    }
                }

//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(enter)) {
//                            final SearchResultsState currentState = searchResultsViewModel.getState();
//
//                            searchResultsController.execute(
//                                    currentState.getSearchTitle()
//                            );
//                        }
//                    }
//                }
        );

        // create the search bar - contains the search label, the input field, and the enter button
        final JPanel searchBar = new JPanel();
        searchBar.add(new JLabel(searchResultsViewModel.SEARCH_LABEL));
        searchBar.add(searchInputField);
        searchBar.add(enter);

        // TODO create the panel that displays the results of the search input
        this.results = new JPanel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(homeButton, BorderLayout.WEST);
        this.add(title, BorderLayout.CENTER);
        this.add(searchBar);
        this.add(results);
    }

    /**
     * Create a panel for an individual movie.
     * @param title is the title of the movie panel
     */
    private JPanel createMoviePanel(String title) {
        final CommonMovie movie = new CommonMovie(title);

        final JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BorderLayout(10, 10));

        // TODO: Add movie poster
        final JLabel posterLabel = new JLabel(new ImageIcon());
        posterLabel.setPreferredSize(new Dimension(100, 150));

        // Add movie title
        final JLabel titleLabel = new JLabel(movie.getTitle());

        // Add "See More" button
        final JButton seeMoreButton = new JButton(searchResultsViewModel.SEE_MORE_LABEL);
        seeMoreButton.addActionListener(
                evt -> searchResultsController.switchToMovieView()
        );
        // Arrange components
        final JPanel textPanel = new JPanel();
        textPanel.add(titleLabel);
        textPanel.add(seeMoreButton);

        moviePanel.add(posterLabel, BorderLayout.WEST);
        moviePanel.add(textPanel, BorderLayout.CENTER);

        return moviePanel;
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        // TODO: implement this

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SearchResultsState state = (SearchResultsState) evt.getNewValue();
        setFields(state);
        searchResultsErrorField.setText(state.getSearchError());
    }

    private void setFields(SearchResultsState state) {
        searchInputField.setText(state.getSearchTitle());
    }

    public String getViewName() {
        return viewName;
    }

    public void setSearchResultsController(SearchResultsController searchResultsController) {
        this.searchResultsController = searchResultsController;
    }
}
