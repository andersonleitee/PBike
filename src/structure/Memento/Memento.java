package Memento;

public class Memento {
    private Object state;

    public Memento(Object state){
        this.state = state;
    }

    public Object getState(){return this.state;}
    public void setState(Object state){this.state = state;}

}
