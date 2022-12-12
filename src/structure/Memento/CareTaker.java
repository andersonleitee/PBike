package structure.Memento;

import java.util.Stack;

public class CareTaker {
    private Stack<Memento> historic = new Stack<>();
    public Originator originator;

    public CareTaker(Originator o){
        this.originator = o;
    }

    public void saveState(){
        historic.push(originator.createMemento());
    }

    public void undo(){
        originator.setMemento(historic.pop());
    }

}
