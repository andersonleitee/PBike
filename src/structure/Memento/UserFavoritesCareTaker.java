package structure.Memento;

public class UserFavoritesCareTaker extends CareTaker {

    public UserFavoritesCareTaker(UserFavoritesEditor editor){
        this.editor = editor;
    }

    public void saveState(){
        historic = editor.createMemento();
    }

    public void undo(){
        historic.restore();
    }

}
