package structure.Memento;

public abstract class CareTaker {
    
    private Memento historic = null;
    private Editor editor;

    public abstract void saveState(){}

    public abstract void undo(){}

}
