package structure.Memento;

import controller.DockManager;
import java.util.HashSet;

public class UserFavoritesEditor extends Editor {
    private HashSet<int> favoriteDocks = new HashSet<int>();

    public void addFavorite(int id) {
        favoriteDocks.add(id);
    }

    public void removeFavorite(int id) {
        favoriteDocks.remove(id);
    }

    public boolean getFavorite(int id) {
        if (favoriteDocks.contains(id)) {
            return true;
        }

        return false;
    }

    public void setFavorites(HashSet<int> favoriteDocks) {
        this.favoriteDocks = favoriteDocks;
    }

    public UserFavoritesMemento createMemento(){
        return new UserFavoritesMemento(this, favoriteDocks);
    }

}
