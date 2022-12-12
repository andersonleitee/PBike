package structure.Memento;

public abstract class Originator {
    protected Object state = null;

    public void setMemento(Memento memento){
        this.state = memento.getState();
    }

    public Memento createMemento(){
        return new Memento(state);
    }

}
