package model.Bike;

import structure.Factory.Entity;

public class Bike implements Entity {
    private int id;

    public Bike(){}

    public Bike(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
