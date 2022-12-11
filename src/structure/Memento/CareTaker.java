package structure.Memento;

import java.util.Stack;

public class CareTaker {
    private Stack<Memento.Memento> historic = new Stack<>();
    public Memento.Originator originator;

    public CareTaker(Memento.Originator o){
        this.originator = o;
    }

    public void saveState(){
        historic.push(originator.createMemento());
    }

    public void undo(){
        originator.setMemento(historic.pop());
    }

}
