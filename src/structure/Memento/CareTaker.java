package structure.Memento;

public abstract class CareTaker {
    
    protected Memento historic = null;
    protected Editor editor;

    public abstract void saveState();

    public abstract void undo();

}
