package structure.Memento;

import java.util.HashSet;
import java.util.Set;

public class UserFavoritesEditor extends Editor {
    private Set<Integer> favoriteDocks = new HashSet<Integer>();

    public UserFavoritesEditor(){}
    
    public void addFavorite(int id) {
        favoriteDocks.add(id);
    }

    public void removeFavorite(int id) {
        favoriteDocks.remove(id);
    }

    public Set<Integer> getFavorites() {
        return favoriteDocks;
    }

    public void setFavorites(Set<Integer> favoriteDocks) {
        this.favoriteDocks = favoriteDocks;
    }

    public UserFavoritesMemento createMemento(){
        return new UserFavoritesMemento(this, favoriteDocks);
    }

}
