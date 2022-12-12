package controller;

import infrastructure.ExceptionFull;
import infrastructure.ExceptionEmpty;
import model.Dock.Dock;
import model.Bike.Bike;
import model.Dock.DockCreator;
import structure.Factory.Entity;

import java.util.ArrayList;

public class DockManager {
    private ArrayList<Dock> docks = new ArrayList<Dock>();
    private ArrayList<ArrayList<Bike>> bikesPerDock = new ArrayList<ArrayList<Bike>>();
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
        bikesPerDock.add(new ArrayList<Bike>());

        return idGenerator - 1;
    }

    public boolean addBike(int dockId, Bike bike) {
        try {
            if (bikesPerDock.get(dockId).size() < docks.get(dockId).getCapacity()) {
                bikesPerDock.get(dockId).add(bike);
            }
            else {
                throw new ExceptionFull(dockId);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bike removeBike(int dockId) {
        try {
            if (!bikesPerDock.get(dockId).isEmpty()) {
                return bikesPerDock.get(dockId).remove(0);
            }
            else {
                throw new ExceptionEmpty(dockId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // public Dock delete(int id) {
    //     Dock dock = null;

    //     try {
    //         dock = docks.get(id);
    //         docks.remove(id);
    //         bikesPerDock.remove(id);
    //     }
    //     catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     return dock;
    // }
}
