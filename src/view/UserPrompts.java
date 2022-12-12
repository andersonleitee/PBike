package view;

import controller.UserManager;
import structure.Factory.Entity;
import model.User.User;
import model.User.UserCreator;
import structure.Adapter.UserValidatorAdapter;

import java.util.Objects;

public class UserPrompts extends SuperPrompts {

    private UserManager userManager = new UserManager();
    private UserCreator userCreator = new UserCreator();
    private UserValidatorAdapter validator = new UserValidatorAdapter();
    private Long id;
    private String login, password;

    public UserPrompts(){}

    public boolean userLogin(){
        System.out.println("Type here your user login: ");
        String login = scanner.nextLine();

        System.out.println("Type here your user password");
        String password = scanner.nextLine();

        boolean ok = false;
        for(User u : userManager.get()){
            if (Objects.equals(u.getLogin(), login) &&
                    Objects.equals(u.getPassword(), password)) {
                ok = true;
                break;
            }
        }
        return ok;
    }

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

            userCreator.setLoginAndPassword(login, password);
            u = super.entityCreate(userCreator);
            if(!validator.validateUser((User) u))
                break;
            else
                System.out.println(DATA_ERROR);
        }
        return (User) u;
    }

}
