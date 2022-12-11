package Memento;

public abstract class Originator {
    protected Object state = null;

    public void setMemento(Memento.Memento memento){
        this.state = memento.getState();
    }

    public Memento.Memento createMemento(){
        return new Memento.Memento(state);
    }

}
