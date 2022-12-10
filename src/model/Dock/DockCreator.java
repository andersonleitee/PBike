package model.Dock;

import structure.Factory.Creator;
import structure.Factory.Entity;

public class DockCreator extends Creator {
    private int id, capacity;
    @Override
    public Entity factoryMethod() {
        return new Dock(id, capacity);
    }

    public void setIdAndCapacity(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }
}
