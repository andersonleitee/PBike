package model.Bike;

import structural.Factory.Creator;
import structural.Factory.Entity;

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
