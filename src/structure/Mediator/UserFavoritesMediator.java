package structure.Mediator;

import controller.DockManager;
import structure.Memento.UserFavoritesEditor;
import structure.Memento.UserFavoritesCareTaker;

import structure.Singleton.SingletonDockManager;

import model.Dock.Dock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserFavoritesMediator extends Mediator {
    private Map<Integer, UserFavoritesEditor> uFavEditors = new HashMap<Integer, UserFavoritesEditor>();
    private Map<Integer, UserFavoritesCareTaker> uFavCareTakers = new HashMap<Integer, UserFavoritesCareTaker>();

    private final DockManager dockManager = SingletonDockManager.getInstance();

    public UserFavoritesMediator(){}

    public void put(Long id) {
        uFavEditors.put(id.intValue(), new UserFavoritesEditor());
        uFavCareTakers.put(id.intValue(), new UserFavoritesCareTaker(uFavEditors.get(id.intValue())));
    }

    public void addFavoriteDock(Long userId, int dockId) {
        uFavEditors.get(userId.intValue()).addFavorite(dockId);
    }

    public void removeFavoriteDock(Long userId, int dockId) {
        uFavEditors.get(userId.intValue()).removeFavorite(dockId);
    }

    public void saveFavoriteDocks(Long userId) {
        uFavCareTakers.get(userId).saveState();
    }

    public void restoreLastSavedFavoriteDocks(Long userId) {
        uFavCareTakers.get(userId).undo();
    }

    public ArrayList<Dock> getFavoriteDocks(Long userId) {
        ArrayList<Integer> favoriteDocksIds = new ArrayList<Integer>(
            uFavEditors.get(userId.intValue()).getFavorites());
        ArrayList<Dock> favoriteDocks = new ArrayList<Dock>();

        for(int i = 0; i < favoriteDocksIds.size(); i++) {
            favoriteDocks.add(dockManager.getById(favoriteDocksIds.get(i)));
        }

        return favoriteDocks;
    }
}
