package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

import javax.swing.*;

import interface_adapter.survey1.SubmitController;
import interface_adapter.survey1.Survey1State;
import interface_adapter.survey1.Survey1ViewModel;
import use_case.survey1.CreateGenreMap;

/**
 * The Survey View for when the user creates an account.
 * we need to call API to get the list of genres
 */
public class Survey1View extends JPanel implements PropertyChangeListener {
    private final CreateGenreMap genreMap = (CreateGenreMap) new CreateGenreMap().getGenreMap();

    private final String viewName = "survey step 1/2";
    private final Survey1ViewModel survey1ViewModel;

    private final Set<String> selectedGenres = new HashSet<>();
    private SubmitController submitController;

    private final JButton submit;

    public Survey1View(Survey1ViewModel survey1ViewModel) {
        this.survey1ViewModel = survey1ViewModel;
        this.survey1ViewModel.addPropertyChangeListener(this);

        final JLabel surveyQuestion = new JLabel("Select 3 of your favorite genres:");
        final JPanel surveyQuestionPanel = new JPanel();
        surveyQuestionPanel.add(surveyQuestion);

        final JPanel genreButtonsPanel = new JPanel();
        for (String genre : genreMap.keySet()) {
            final JButton button = new JButton(genre);
            addGenreButton(button, genre);
            genreButtonsPanel.add(button);
        }

        submit = new JButton("Submit");
        // Disable submit initially
        submit.setEnabled(true);
        final JPanel submitPanel = new JPanel();
        submitPanel.add(submit);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        submit.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(submit)) {
                        // 1. get the state out of the survey1ViewModel.
                        // 2. Execute the submit Controller.
                        final String uname = survey1ViewModel.getState().getUsername();
                        this.submitController.switchToSurveySecondPageView(uname);
                    }
                }
        );

        this.add(surveyQuestionPanel);
        this.add(genreButtonsPanel);
        this.add(submitPanel);
    }

    // Method to add action listeners to genre buttons
    private void addGenreButton(JButton button, String genre) {
        button.addActionListener(e -> {
            if (selectedGenres.contains(genre)) {
                // If the genre is already selected, deselect it
                selectedGenres.remove(genre);
                button.setBackground(null); // Reset button color to default
            } else if (selectedGenres.size() < 3) {
                // If less than 3 genres are selected, add the new genre
                selectedGenres.add(genre);
                button.setBackground(Color.GREEN); // Highlight the button as selected
            }

            // Enable the submit button only if exactly 3 genres are selected
            submit.setEnabled(selectedGenres.size() == 3);
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Survey1State state = (Survey1State) evt.getNewValue();
        if (state.getGenre1() != null) {
            // Set the selected genres in the view
            selectedGenres.clear();
            selectedGenres.add(state.getGenre1());
            selectedGenres.add(state.getGenre2());
            selectedGenres.add(state.getGenre3());

            // Enable the submit button only if exactly 3 genres are selected
            submit.setEnabled(selectedGenres.size() == 3);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSubmitController(SubmitController submitController) {
        this.submitController = submitController;
    }

    public CreateGenreMap getGenreMap() {
        return genreMap;
    }
}
