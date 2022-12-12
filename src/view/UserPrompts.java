package view;

import controller.UserManager;
import structure.Factory.Entity;
import model.User.User;
import model.User.UserCreator;
import structure.Adapter.UserValidatorAdapter;
import structure.Singleton.SingletonUserManager;

import java.util.Objects;

public class UserPrompts extends SuperPrompts {
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
        if(SingletonUserManager.getInstance().getByLogin(login) != null){
            if(Objects.equals(SingletonUserManager.getInstance().getByLogin(login).getPassword(), login)){
                ok = true;
            }
        }
        return ok;
    }

    public void showAllUsers(){
        System.out.println(SingletonUserManager.getInstance().get());
    }

    public boolean addNewUser(){
        return SingletonUserManager.getInstance().post(createUser());
    }

    public boolean updateUser(){
        System.out.println("Type here the user id to be updated");
        id = scanner.nextLong();

        return SingletonUserManager.getInstance().put(id, createUser());
    }

    public void deleteUser(){
        System.out.println("Type here the user id to be deleted");
        id = scanner.nextLong();

        Entity u = SingletonUserManager.getInstance().delete(id);
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
