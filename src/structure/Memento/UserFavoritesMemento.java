package structure.Memento;

import java.util.HashSet;
import java.util.Set;

public class UserFavoritesMemento extends Memento {
    private UserFavoritesEditor editor;
    private Set<Integer> favoriteDocks = new HashSet<Integer>();

    public UserFavoritesMemento(UserFavoritesEditor editor, Set<Integer> favoriteDocks) {
        this.editor = editor;
        this.favoriteDocks = favoriteDocks;
    }

    @Override
    public void setState() {

    }

    public void restore() {
        editor.setFavorites(favoriteDocks);
    }

}
