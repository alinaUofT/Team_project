package use_case.watchlists.delete;

import entity.UserWatchlist;

/**
 * The Rename Watchlist Interactor.
 */
public class DeleteWatchlistInteractor implements DeleteWatchlistInputBoundary {
    private final DeleteWatchlistUserDataAccessInterface userDataAccessObject;
    private final DeleteWatchlistOutputBoundary userPresenter;

    public DeleteWatchlistInteractor(DeleteWatchlistUserDataAccessInterface userDataAccessObject,
                                     DeleteWatchlistOutputBoundary userPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
    }

    /**
     * Executes the rename watchlist use case.
     *
     * @param deleteInputData the input data
     */
    @Override
    public void execute(DeleteWatchlistInputData deleteInputData) {
//        TODO save to the database
        deleteInputData.getCurrentUser().getWatchlists().remove(deleteInputData.getIndex());
        userPresenter.execute();
    }
}
