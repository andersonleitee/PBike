package structure.Memento;

import controller.DockManager;
import java.util.HashSet;
import java.util.Set;

public class UserFavoritesEditor extends Editor {
    private Set<int> favoriteDocks = new HashSet<int>();

    UserFavoritesEditor(){}
    
    public void addFavorite(int id) {
        favoriteDocks.add(id);
    }

    public void removeFavorite(int id) {
        favoriteDocks.remove(id);
    }

    public boolean getFavorites() {
        return favoriteDocks;
    }

    public void setFavorites(Set<int> favoriteDocks) {
        this.favoriteDocks = favoriteDocks;
    }

    public UserFavoritesMemento createMemento(){
        return new UserFavoritesMemento(this, favoriteDocks);
    }

}
