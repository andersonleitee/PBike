package structure.Memento;

public class UserFavoritesMemento extends Memento {
    private UserFavoritesEditor editor;
    private HashSet<int> favoriteDocks = new HashSet<int>();

    public UserFavoritesMemento(UserFavoritesEditor editor, HashSet<int> favoriteDocks) {
        this.editor = editor;
        this.favoriteDocks = favoriteDocks;
    }

    public void restore() {
        editor.setFavorites(favoriteDocks);
    }

}
