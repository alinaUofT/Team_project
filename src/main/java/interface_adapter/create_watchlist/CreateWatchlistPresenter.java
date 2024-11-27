package interface_adapter.create_watchlist;

import interface_adapter.ViewManagerModel;
import interface_adapter.watchlist.WatchlistState;
import interface_adapter.watchlist.WatchlistViewModel;
import interface_adapter.watchlists.WatchlistsState;
import interface_adapter.watchlists.WatchlistsViewModel;
import use_case.create_watchlist.CreateWatchlistOutputBoundary;
import use_case.create_watchlist.CreateWatchlistOutputData;

public class CreateWatchlistPresenter implements CreateWatchlistOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private WatchlistsViewModel watchlistsViewModel;
    private WatchlistViewModel watchlistViewModel;

    public CreateWatchlistPresenter(ViewManagerModel viewManagerModel,
                                    WatchlistsViewModel watchlistsViewModel,
                                    WatchlistViewModel watchlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.watchlistsViewModel = watchlistsViewModel;
        this.watchlistViewModel = watchlistViewModel;
    }

    @Override
    public void prepareSuccessView(CreateWatchlistOutputData outputData) {
        final WatchlistState watchlistState = watchlistViewModel.getState();
        watchlistState.setUsername(outputData.getUsername());
        watchlistViewModel.setState(watchlistState);
        watchlistViewModel.firePropertyChanged();

        viewManagerModel.setState(watchlistViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final WatchlistsState watchlistsState = watchlistsViewModel.getState();
        watchlistsState.setListError(errorMessage);
        watchlistsViewModel.firePropertyChanged();
    }
}