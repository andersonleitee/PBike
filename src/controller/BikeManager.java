package controller;

import infrastructure.ExceptionUnavailable;
import model.Bike.Bike;
import model.Bike.BikeCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BikeManager {
    private Map<int, Bike> bikes = new HashMap<int, Bike>();
    private Map<int, boolean> taken = new HashMap<int, boolean>;
    int idGenerator = 0;
    private BikeCreator creator = new BikeCreator();

    public BikeManager(){}

    public ArrayList<Bike> get() {
        return new ArrayList<Bike>(bikes.values());
    }

    public Bike getById(int id) {        
        return bikes.get(id);        
    }

    public int newBike() {
        idGenerator++;
        creator.setId(idGenerator);
        bikes.put(idGenerator, (Bike) creator.factoryMethod());
        taken.put(idGenerator, false);

        return idGenerator;
    }

    public Bike takeBike(int id) {
        if(validateBikeAvailability(id, true)) {
            taken.get(id) = true;
            
            return bikes.get(id);
        }

        return null;
    }

    public boolean returnBike(int id) {
        if(validateBikeAvailability(id, false)) {
            taken.get(id) = false;
            
            return true;
        }

        return false;
    }

    public Bike delete(int id) {
        Bike bike = null;

        try {
            bike = bikes.get(id);
            bikes.remove(id);
            taken.remove(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return bike;
    }

    private boolean validateBikeAvailability(int id, boolean availability) {
        try {
            if (taken.get(id) == availability) {
                throw new ExceptionUnavailable(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
