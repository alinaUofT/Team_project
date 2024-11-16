package use_case.movie;

// TODO: add to these later
/**
 * DAO for the Movie Use Case.
 */
public interface MovieUserDataAccess {

    /**
     * Checks if the given title exists.
     * @param title the title to look for
     * @return true if a movie with the given title exists; false otherwise
     */
    boolean existsByName(String title);
}
