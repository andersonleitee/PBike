package view;

import structural.Factory.Creator;
import structural.Factory.Entity;

import java.util.Scanner;

public abstract class SuperPrompts {
    protected static Scanner scanner = new Scanner(System.in);

    protected final String CHOICE_ERROR = "Unavailable option, please try again!";
    protected final String DATA_ERROR = "Invalid information, please try again";

    protected Entity entityCreate(Creator c) {
        return c.factoryMethod();
    }

}
