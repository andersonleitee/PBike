package view;

import controller.UserManager;
import factory.Entity;
import model.user.User;
import model.user.UserCreator;

import java.util.Scanner;

public class UserPrompts extends SuperPrompts{

    UserManager userManager = new UserManager();
    UserCreator userCreator = new UserCreator();
    Long id;
    String login, password;

    public UserPrompts(){}

    public void showAllUsers(){
        System.out.println(userManager.get());
    }

    public boolean addNewUser(){
        return userManager.post(createUser());
    }

    public boolean updateUser(){
        System.out.println("Type here the user id to be updated");
        id = scanner.nextLong();

        return userManager.put(id, createUser());
    }

    public void deleteUser(){
        System.out.println("Type here the user id to be deleted");
        id = scanner.nextLong();

        Entity u = userManager.delete(id);
        System.out.println("Deleted User: " + u + "\n\n");
    }


    private User createUser(){
        Entity u = null;

        while(true){
            System.out.println("Type here the user login: ");
            login = scanner.nextLine();

            System.out.println("Type here the user password: ");
            password = scanner.nextLine();

            u = super.entityCreate(userCreator);
            if(!userManager.validateUser((User) u))
                break;
            else
                System.out.println(DATA_ERROR);
        }
        return (User) u;
    }

}
