package model.Bike;

import structure.Factory.Creator;
import structure.Factory.Entity;

public class BikeCreator extends Creator {
    int id;
    @Override
    public Entity factoryMethod() {
        return new Bike(id);
    }

    public void setId(int id){
        this.id = id;
    }
}
