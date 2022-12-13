package structure.Memento;

public abstract class Editor {
    
    public abstract Memento createMemento();

    public abstract void setFavorites(Memento historic);
}
