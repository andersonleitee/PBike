package controller;

import model.User.User;
import model.Bike.Bike;
import model.Dock.Dock;

import structure.Adapter.UserValidatorAdapter;
import structure.Memento.UserFavoritesEditor;
import structure.Memento.UserFavoritesCareTaker;
import structure.Singleton.SingletonDockManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private Map<Integer, Bike> bikes = new HashMap<Integer, Bike>();
    private UserValidatorAdapter validator = new UserValidatorAdapter();
    private Map<Integer, UserFavoritesEditor> uFavEditors = new HashMap<Integer, UserFavoritesEditor>();
    private Map<Integer, UserFavoritesCareTaker> uFavCareTaker = new HashMap<Integer, UserFavoritesCareTaker>();
    private final DockManager dockManager = SingletonDockManager.getInstance();

    User u = null;

    public UserManager() {
    }
    public ArrayList<User> get() {
        return this.users;
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (Objects.equals(user.getLogin(), login))
              //  logged(user);
                return user;
        }
        return null;
    }

    public boolean post(User user) {
        if (validator.validateUser(user)) {
            this.users.add(user);
            return true;
        } else
            return false;

    }

    public boolean put(Long id, User user) {
        if (validator.validateUser(user) && id > 0) {
            users.set(id.intValue(), user);
            uFavEditors.put(id.intValue(), new UserFavoritesEditor());
            uFavCareTaker.put(id.intValue(), new UserFavoritesCareTaker(uFavEditors.get(id.intValue())));

            return true;
        } else
            return false;

    }

    public User delete(Long id) {
        User u = null;

        try {
            u = users.get(id.intValue());
            users.remove(id.intValue());
            bikes.remove(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    // bikes

    public boolean takeBike(Long id, Bike bike) {
        try {
            if (bikes.get(id.intValue()) != null) {
                return false;
            }
            bikes.put(id.intValue(), bike);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean returnBike(Long id) {
        try {
            if (bikes.get(id.intValue()) == null) {
                return false;
            }
            bikes.put(id.intValue(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public Bike getBike(Long id) {
        try {
            return bikes.get(id.intValue());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // favorite docks

    public void addFavoriteDock(Long userId, int dockId) {
        uFavEditors.get(userId.intValue()).addFavorite(dockId);
    }

    public void removeFavoriteDock(Long userId, int dockId) {
        uFavEditors.get(userId.intValue()).removeFavorite(dockId);
    }

    public void saveFavoriteDocks(Long userId) {
        uFavCareTaker.get(userId).saveState();
    }

    public void restoreLastSavedFavoriteDocks(Long usedId) {
        uFavCareTaker.get(usedId).undo();
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
