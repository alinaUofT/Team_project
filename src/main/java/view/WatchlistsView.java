package view;

import entity.CommonUserWatchlist;
import entity.User;
import entity.UserWatchlist;
import interface_adapter.watchlists.WatchlistsController;
import interface_adapter.watchlists.WatchlistsState;
import interface_adapter.watchlists.WatchlistsViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * The View for the screen showing a list of watchlists.
 */
public class WatchlistsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;

    private final WatchlistsViewModel watchlistsViewModel;
    private WatchlistsController watchlistsController;

    private JPanel topLine;
    private JButton createWatchlist;
    private JButton pwl;
    private JPanel watchlistButtons;

    private final JTextField listNameField = new JTextField();

    private int x = 0;

    public WatchlistsView(WatchlistsViewModel watchlistsViewModel) {
        this.watchlistsViewModel = watchlistsViewModel;
        this.viewName = watchlistsViewModel.getViewName();
        watchlistsViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.topLine = new JPanel();
        topLine.setLayout(new BoxLayout(topLine, BoxLayout.X_AXIS));
        topLine.setPreferredSize(new Dimension(400, 50));

        final JButton home = new JButton(watchlistsViewModel.HOME_LABEL);
        home.setAlignmentX(Component.LEFT_ALIGNMENT);
        home.addActionListener(
                evt -> watchlistsController.switchToHomeView()
        );
        topLine.add(home);

        final JLabel title = new JLabel(watchlistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        topLine.add(title);
        this.add(topLine);

        this.createWatchlist = new JButton(watchlistsViewModel.CREATE_LIST_LABEL);

        createWatchlist.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createWatchlist);
        createWatchlist.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createWatchlist)) {
                            createNewListPopUpView();
                        }
                    }
                }
        );
        this.watchlistButtons = new JPanel();
        this.watchlistButtons.setLayout(new BoxLayout(this.watchlistButtons, BoxLayout.Y_AXIS));
        this.pwl = new JButton(watchlistsViewModel.PWL_LABEL);
        this.pwl.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.pwl.addActionListener(
                evt -> {
                    final User currentUser = watchlistsViewModel.getState().getCurrentUser();

                    watchlistsController.goToPWL(currentUser);
                }
        );
        this.watchlistButtons.add(this.pwl);
        this.add(this.watchlistButtons);
        this.setPreferredSize(new Dimension(400, 300));
        final Color backcolor = new Color(255, 255, 255);
        this.setBackground(backcolor);


    }

    private void updateWatchlists() {
        final List<UserWatchlist> watchlists = watchlistsViewModel.getState().getCurrentUser().getWatchlists();
        for (int i = 0; i < watchlists.size(); i++) {
            final JPanel buttons = new JPanel();
            buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
            final JButton watchlist = new JButton(watchlists.get(i).getListName());
            final int ind = i;
            watchlist.addActionListener(
                    evt -> {
                        if (evt.getSource().equals(watchlist)) {
                            final User currentUser = watchlistsViewModel.getState().getCurrentUser();

                            watchlistsController.goToWatchlist(currentUser,
                                    ind);
                        }
                    }
            );
            buttons.add(watchlist);
            final JButton rename = new JButton(watchlistsViewModel.RENAME_LABEL);
            //            rename.addActionListener(
            //                    evt -> {
            //                        if (evt.getSource().equals(rename)) {
            //                            final User currentUser = watchlistsViewModel.getState().getCurrentUser();
            //
            //                            renameWatchlistController.execute(currentUser, ind);
            //                        }
            //                    }
            //            );
            buttons.add(rename);
            final JButton delete = new JButton(watchlistsViewModel.DELETE_LABEL);
            //            delete.addActionListener(
            //                    evt -> {
            //                        if (evt.getSource().equals(delete)) {
            //                            final User currentUser = watchlistsViewModel.getState().getCurrentUser();
            //
            //                            deleteWatchlistController.execute(currentUser, ind);
            //                        }
            //                    }
            //            );
            buttons.add(delete);
            this.watchlistButtons.add(buttons);
        }
    }

    /**
     * View for Create a New List Pop-Up Window.
     */
    private void createNewListPopUpView() {
        // final int maxChar = 75;
        final JPanel panel = new JPanel();

        // Adjusting panel size
        panel.setPreferredSize(new Dimension(500, 200));

        final JPanel textPanel = new JPanel(new BorderLayout());
        // Text field for naming new list
        final JLabel enterNameLabel = new JLabel("Enter List Name:");
        // final JTextField listNameField = new JTextField(40);

        final int maxChar = 100;
        final JLabel characterLimitLabel = new JLabel("Character Limit: " + x + "/" + maxChar);

        listNameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateCharacterCount(1);
            }

            public void removeUpdate(DocumentEvent e) {
                updateCharacterCount(-1);
            }

            public void changedUpdate(DocumentEvent e) {
                /* Not needed for plain text fields */
            }

            private void updateCharacterCount(int increment) {
                x += increment;
                characterLimitLabel.setText("Character Limit: " + x + "/" + maxChar);
            }
        });

        // Add text field components to panel
        textPanel.add(enterNameLabel, BorderLayout.NORTH);
        textPanel.add(listNameField, BorderLayout.CENTER);
        textPanel.add(characterLimitLabel, BorderLayout.SOUTH);

        // Add components to the panel
        panel.add(textPanel);

        // Create a custom dialog with our panel
        final int option = JOptionPane.showOptionDialog(this, panel, "Create a New List",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"Create List", "Cancel"}, null);

        if (option == JOptionPane.YES_OPTION) {
            final String listName = listNameField.getText().trim();
            if (!listName.isEmpty()) {
                final WatchlistsState currentState = watchlistsViewModel.getState();
                // Create a new watchlist entity with the list name
                final UserWatchlist watchlist = new CommonUserWatchlist(listName);
                currentState.getCurrentUser().getWatchlists().add(watchlist);
                updateWatchlists();
            }
        }
        updateWatchlists();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }

    public void setWatchlistsController(WatchlistsController controller) {
        this.watchlistsController = controller;
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.updateWatchlists();
    }
}
