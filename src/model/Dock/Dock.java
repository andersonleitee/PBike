package model.Dock;
import structure.Factory.Entity;

import java.util.ArrayList;

public class Dock implements Entity {
    private int id;
    private int capacity;

    public Dock(){}

    public Dock(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
