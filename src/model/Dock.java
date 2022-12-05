package model;
import java.util.ArrayList;

public class Dock {
    private int id;
    private int capacity;
    private ArrayList<Bike> bikes = new ArrayList<Bike>();

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

    public void addBike(Bike bike) {
        bikes.add(bike);
    }

    public void removeBike(int id) {
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getId() == id)
            {
                bikes.remove(i);
                break;
            }
        }
    }

    public boolean hasBike(int id) {
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getId() == id)
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    public int getBikesSize() {
        return bikes.size();
    }
}
