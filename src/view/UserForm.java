package view;

import model.User;
import controller.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

public class UserForm {
    private ArrayList<User> users = new ArrayList<User>();
    private UserManager userManager;


    public UserForm(UserManager userManager) {
        this.userManager = userManager;
    }


    public ArrayList<User> HttpRequest_GET(){
        return this.users;
    }

    public ArrayList<User> HttpRequest_GETBYNAME(String name){
        return this.users;
    }


    public boolean HttpRequest_POST(User u){
        if(this.validateUser(u)) {
            this.users.add(u);
            return true;
        }
        else return false;

    }

    public boolean HttpRequest_PUT(Long id, User u){
        if(this.validateUser(u) && id > 0) {
            users.set(id.intValue(), u);

            return true;
        }
        else return false;

    }

    public User HttpRequest_DELETE(Long id){
        User u = null;

        if(id > 0){
            u = users.get(id.intValue());
            users.remove(id);
        }
        else
            throw new ArrayIndexOutOfBoundsException();


        return u;
    }

    private boolean validateUser(User user){
        return userManager.userValidate(user);
    }

    public User createUser(){
        Scanner scanner = new Scanner(System.in);
        String login, password;

        System.out.println("Type here the user login: ");
        login = scanner.nextLine();

        System.out.println("Type here the user password: ");
        password = scanner.nextLine();

        return new User(login, password);
    }
}
