package view;

import view.UserPrompts;

public class CLIPrompts extends SuperPrompts {
    private final String MAIN_MENU = "Welcome, what do you want do? \n\n" +
            "[ 1 ] - Login\n" +
            "[ 2 ] - User Crud\n" +
            "[ 0 ] - Exit\n\n" +
            "Choice: ";
    private final String USER_CRUD_MENU = "What do you want to do now?\n" +
            "[ 1 ] - See the users list\n" +
            "[ 2 ] - Add a new user\n" +
            "[ 3 ] - Update an user\n" +
            "[ 4 ] - Remove an user\n " +
            "\n [ 0 ] - Return\n\n" +
            "Choice: ";
    private UserPrompts userPrompts = new UserPrompts();

    public CLIPrompts() {
    }

    public void start() {
        int choice = -1;
        String input;

        while (true) {
            System.out.print(MAIN_MENU);
            input = scanner.nextLine();
            choice = Integer.parseInt(input);

            switch (choice) {

                case 1:
                    login();
                    break;
                case 2:
                    userCrud();
                    break;
                case 0:
                    return;

                default:
                    System.out.println(CHOICE_ERROR);
            }
        }
    }

    private void userCrud(){
        int choice = -1;
        String input;


        while (true) {
            System.out.print(USER_CRUD_MENU);
            input = scanner.nextLine();
            choice = Integer.parseInt(input);

            switch (choice) {

                case 1:
                    userPrompts.showAllUsers();
                    break;
                case 2:
                    userPrompts.addNewUser();
                    break;
                case 3:
                    userPrompts.updateUser();
                    break;
                case 4:
                    userPrompts.deleteUser();
                    break;
                case 0:
                    return;

                default:
                    System.out.println(CHOICE_ERROR);
            }
        }
    }
    private void login(){
        if(!userPrompts.userLogin())
            System.out.println("Wrong user login or password");
        else
            System.out.println("Login Successful");
    }
}