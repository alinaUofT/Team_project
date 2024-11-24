package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.recommendations.RecommendationsController;
import interface_adapter.recommendations.RecommendationsViewModel;

/**
 * The View for the recommendations screen.
 */
public class RecommendationsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName;

    private final RecommendationsViewModel recommendationsViewModel;
    private RecommendationsController recommendationsController;

    private final JPanel recommendationsPanel = new JPanel();

    private final JButton home;
    private final JButton refresh;

    private final JButton movie1;
    private final JButton movie2;
    private final JButton movie3;

    public RecommendationsView(RecommendationsViewModel recommendationsViewModel) {
        this.recommendationsViewModel = recommendationsViewModel;
        this.viewName = recommendationsViewModel.getViewName();

        recommendationsViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel(recommendationsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel homeButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.home = new JButton(recommendationsViewModel.HOME_LABEL);
        homeButton.add(home);
        home.setAlignmentX(Component.LEFT_ALIGNMENT);

        home.addActionListener(
                evt -> recommendationsController.switchToHomeView()
        );

        this.refresh = new JButton(recommendationsViewModel.REFRESH_LABEL);
        refresh.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        this.recommendationsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: implement according to recommendations
        this.movie1 = new JButton("Movie 1");
        this.movie2 = new JButton("Movie 2");
        this.movie3 = new JButton("Movie 3");

        recommendationsPanel.add(movie1);
        recommendationsPanel.add(movie2);
        recommendationsPanel.add(movie3);

        this.add(homeButton);
        this.add(title);
        this.add(recommendationsPanel);
        this.add(refresh);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }

    public void setRecommendationsController(RecommendationsController controller) {
        this.recommendationsController = controller;
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
