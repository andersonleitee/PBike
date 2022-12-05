package view;

import factory.Creator;
import factory.Entity;

import java.util.Scanner;

public abstract class SuperPrompts {
    static Scanner scanner = new Scanner(System.in);

    protected final String CHOICE_ERROR = "Unavailable option, please try again!";
    protected final String DATA_ERROR = "Invalid information, please try again";

    protected Entity entityCreate(Creator c) {
        return c.factoryMethod();
    }

}
