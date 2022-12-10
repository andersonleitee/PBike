package controller;

import model.Dock.Dock;
import model.Bike.Bike;
import model.Dock.DockCreator;
import structure.Factory.Entity;

import java.util.ArrayList;

public class DockManager {
    private ArrayList<Dock> docks = new ArrayList<Dock>();
    private int idGenerator = 0;
    private DockCreator creator = new DockCreator();

    public DockManager(){}

    public ArrayList<Dock> get() {
        return docks;
    }

    public Dock getById(int id) {
        Dock dock = null;

        try {
            dock = docks.get(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dock;        
    }

    public int newDock(int capacity) {
        Entity u = null;
        idGenerator++;

        creator.setIdAndCapacity(idGenerator, capacity);
        docks.add((Dock) creator.factoryMethod());

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

        try {
            dock = docks.get(id);
            docks.remove(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dock;
    }
}
