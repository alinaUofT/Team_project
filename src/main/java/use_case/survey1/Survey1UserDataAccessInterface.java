package use_case.survey1;

import entity.User;

/**
 * The interface of the DAO for the Survey1 Use Case.
 */
public interface Survey1UserDataAccessInterface {

    /**
     * Returns a User with this username.
     * @param username username of the user
     * @return User with this username
     */
    User get(String username);
}
