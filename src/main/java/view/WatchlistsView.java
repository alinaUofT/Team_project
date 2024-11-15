package view;

import entity.User;
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
import java.util.ArrayList;
import java.util.List;

/**
 * The View for the watchlists screen.
 */
public class WatchlistsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "My Watchlists";

    private final WatchlistsViewModel watchlistsViewModel;
    private WatchlistsController watchlistsController;

    private final JButton home;
    private final JButton createWatchlist;
    private final JButton pwl;
    private List watchlistButtons;

    public WatchlistsView(WatchlistsViewModel watchlistsViewModel) {
        this.watchlistsViewModel = watchlistsViewModel;
        watchlistsViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel(watchlistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.home = new JButton(watchlistsViewModel.HOME_LABEL);
        home.setAlignmentX(Component.RIGHT_ALIGNMENT);
        home.addActionListener(
                evt -> watchlistsController.switchToHomeView()
        );
        this.add(home);
        this.createWatchlist = new JButton(watchlistsViewModel.CREATE_LIST_LABEL);
//        createWatchlist.addActionListener(
//                evt -> createWatchlistController.execute()
//        );
        createWatchlist.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(createWatchlist);
        this.pwl = new JButton(watchlistsViewModel.PWL_LABEL);
        pwl.setAlignmentX(Component.CENTER_ALIGNMENT);
        pwl.addActionListener(
                evt -> {
                    final User currentUser = watchlistsViewModel.getState().getCurrentUser();

                    watchlistsController.goToPWL(currentUser);
                }
        );
        this.add(pwl);
        this.updateWatchlists();

    }

    private void updateWatchlists() {
        final List<String> watchlists = watchlistsViewModel.getState().getCurrentUser().getWatchlists();
        this.watchlistButtons = new ArrayList<JPanel>();
        for (int i = 0; i < watchlists.size(); i++) {
            final JPanel buttons = new JPanel();
            final JButton watchlist = new JButton(watchlists.get(i));
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

    }
}
