package controller;

import infrastructure.ExceptionUnavailable;
import model.Bike.Bike;
import model.Bike.BikeCreator;

import java.util.ArrayList;

public class BikeManager {
    private ArrayList<Bike> bikes = new ArrayList<Bike>();
    int idGenerator = 0;
    private BikeCreator creator = new BikeCreator();

    public BikeManager(){}

    public ArrayList<Bike> get() {
        return bikes;
    }

    public Bike getById(int id) {
        Bike bike = null;

        try {
            bike = bikes.get(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return bike;        
    }

    public int newBike() {
        idGenerator++;
        creator.setId(idGenerator);
        bikes.add((Bike) creator.factoryMethod());

        return idGenerator - 1;
    }

    public Bike takeBike(int id) {
        if(validateBikeAvailability(id, true)) {
            bikes.get(id).setTaken(true);
            
            return bikes.get(id);
        }

        return null;
    }

    public boolean returnBike(int id) {
        if(validateBikeAvailability(id, false)) {
            bikes.get(id).setTaken(false);
            
            return true;
        }

        return false;
    }

    public Bike delete(int id) {
        Bike bike = null;

        try {
            bike = bikes.get(id);
            bikes.remove(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return bike;
    }

    private boolean validateBikeAvailability(int id, boolean availability) {
        try {
            Bike bike = bikes.get(id); // can throw ArrayIndexOutOfBoundsException
            if (bike.getTaken() == availability) {
                throw new ExceptionUnavailable(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
