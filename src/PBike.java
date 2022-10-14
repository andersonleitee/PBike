import view.UserManager;

import java.util.Scanner;


public class PBike {
    private static UserManager userManager;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        Long id;

        while(true) {
            System.out.print(
                    "What do you want to do now?\n" +
                            "[ 1 ] - See the users list\n" +
                            "[ 2 ] - Add a new user\n" +
                            "[ 3 ] - Update an user\n" +
                            "[ 4 ] - Remove an user\n " +
                            "\n [ 0 ] - EXIT\n\n" +
                            "Choice: "
            );
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(userManager.HttpRequest_GET());

                    break;
                case 2:
                    String login, password;

                    System.out.println("Type here the user login: ");
                    login = scanner.nextLine();

                    System.out.println("Type here the user password: ");
                    password = scanner.nextLine();

                    userManager.HttpRequest_POST(userManager.createUser());
                    break;
                case 3:
                    System.out.println("Type here the user id to be updated");
                    id = scanner.nextLong();

                    userManager.HttpRequest_PUT(id, userManager.createUser());

                    break;
                case 4:
                    System.out.println("Type here the user id to be deleted");
                    id = scanner.nextLong();

                    userManager.HttpRequest_DELETE(id);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Unavailable option, please try again!");
            }
        }
    }

}
