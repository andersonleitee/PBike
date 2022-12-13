package structure.Memento;

public class UserFavoritesMemento extends Memento {
    private UserFavoritesEditor editor;
    private Set<int> favoriteDocks = new HashSet<int>();

    public UserFavoritesMemento(UserFavoritesEditor editor, Set<int> favoriteDocks) {
        this.editor = editor;
        this.favoriteDocks = favoriteDocks;
    }

    public void restore() {
        editor.setFavorites(favoriteDocks);
    }

}
