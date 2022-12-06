package controller;

import model.Dock;
import model.Bike;

import java.util.ArrayList;

public class DockManager {
    private ArrayList<Dock> docks = new ArrayList<Dock>();
    private int idGenerator = 0;

    public DockManager(){}

    public ArrayList<Dock> get() {
        return docks;
    }

    public Dock getById(int id) {
        Dock dock = null;

        if (id >= 0 && id < idGenerator)
        {
            dock = docks.get(id);
        }
        else
            throw new ArrayIndexOutOfBoundsException();

        return dock;        
    }

    public int newDock(int capacity) {
        docks.add(new Dock(idGenerator, capacity));
        idGenerator++;

        return idGenerator - 1;
    }

    public boolean addBike(int dockId, Bike bike) {
        try {
            return docks.get(dockId).addBike(bike);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeBike(int dockId, int bikeId) {
        try {
            return docks.get(dockId).removeBike(bikeId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Dock delete(int id) {
        Dock dock = null;

        if (id >= 0 && id < idGenerator)
        {
            dock = docks.get(id);
            docks.remove(id);
        }
        else
            throw new ArrayIndexOutOfBoundsException();
        
        return dock;
    }
}
