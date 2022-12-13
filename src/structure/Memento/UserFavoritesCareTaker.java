package structure.Memento;

import java.util.Stack;

public class UserFavoritesCareTaker extends CareTaker {

    public UserFavoritesCareTaker(UserFavoritesEditor editor){
        this.editor = editor;
    }

    public void saveState(){
        historic = editor.createMemento();
    }

    public void undo(){
        editor.setFavorites(historic);
    }

}
