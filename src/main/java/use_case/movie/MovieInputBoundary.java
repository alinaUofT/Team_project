package use_case.movie;

/**
 * Input Boundary for actions which are related to movies.
 */
public interface MovieInputBoundary {

    /**
     * Executes the movie use case.
     * @param movieInputData the input data
     */
    void execute(MovieInputData movieInputData);

}
