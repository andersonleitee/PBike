package model.Bike;

import structural.Factory.Entity;

public class Bike implements Entity {
    private int id;
    private boolean taken = false;

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

    public boolean getTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
