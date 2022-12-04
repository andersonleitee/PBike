package view;

import controller.UserManager;
import model.User;

import java.util.Scanner;

public class CLIPrompts {
    UserManager userManager = new UserManager();
    Scanner scanner = new Scanner(System.in);


    private final String MENU = "What do you want to do now?\n" +
                                            "[ 1 ] - See the users list\n" +
                                            "[ 2 ] - Add a new user\n" +
                                            "[ 3 ] - Update an user\n" +
                                            "[ 4 ] - Remove an user\n " +
                                            "\n [ 0 ] - EXIT\n\n" +
                                            "Choice: ";

    private final String CHOICE_ERROR = "Unavailable option, please try again!";
    private final String DATA_ERROR = "Invalid information, please try again";
    private String login, password;
    private Long id;



    public CLIPrompts(){}
    public void start() {
        int choice = -1;

        while (true) {
            System.out.print(MENU);
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    showAllUsers();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 0:
                    return;

                default:
                    System.out.println(CHOICE_ERROR);
            }
        }
    }

    private void showAllUsers(){
        System.out.println(userManager.get());
    }

    private boolean addNewUser(){
        return userManager.post(createUser());
    }

    private boolean updateUser(){
        System.out.println("Type here the user id to be updated");
        id = scanner.nextLong();

        return userManager.put(id, createUser());
    }

    private void deleteUser(){
        System.out.println("Type here the user id to be deleted");
        id = scanner.nextLong();

        User u = userManager.delete(id);
        System.out.println("Deleted User: " + u + "\n\n");
    }

    private User createUser(){
        User u = null;

        while(true){
            System.out.println("Type here the user login: ");
            login = scanner.nextLine();

            System.out.println("Type here the user password: ");
            password = scanner.nextLine();

            u = new User(login, password);
            if(userManager.validateUser(u))
                break;
            else
                System.out.println(DATA_ERROR);
        }
        return u;
    }

}
