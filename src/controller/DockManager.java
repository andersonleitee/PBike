package controller;

import infrastructure.ExceptionFull;
import infrastructure.ExceptionEmpty;
import model.Dock.Dock;
import model.Bike.Bike;
import model.Dock.DockCreator;
import structure.Factory.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DockManager {
    private Map<Integer, Dock> docks = new HashMap<Integer, Dock>();
    private Map<Integer, ArrayList<Bike>> bikesPerDock = new HashMap<Integer, ArrayList<Bike>>();
    private int idGenerator = 0;
    private DockCreator creator = new DockCreator();

    public DockManager(){}

    public ArrayList<Dock> get() {
        return new ArrayList<Dock>(docks.values());
    }

    public Dock getById(int id) {
        return docks.get(id);
    }

    public int newDock(int capacity) {
        Entity u = null;
        idGenerator++;

        creator.setIdAndCapacity(idGenerator, capacity);
        docks.put(idGenerator, (Dock) creator.factoryMethod());
        bikesPerDock.put(idGenerator, new ArrayList<Bike>());

        return idGenerator;
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

    public Dock delete(int id) {
        Dock dock = null;

        try {
            dock = docks.get(id);
            docks.remove(id);
            bikesPerDock.remove(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dock;
    }
}
