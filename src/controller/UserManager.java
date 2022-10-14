package controller;

import infrastructure.ExceptionLength;
import infrastructure.ExceptionNumber;
import infrastructure.ExceptionPassNumber;
import model.User;

public class UserManager {
    private final int[] NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public boolean userValidate(User user){
        boolean response = true;

        response = this.loginValidate(user.getLogin()) &&
                    this.passwordValidate(user.getPassword());

        return response;
    }

    private boolean loginValidate(String login){
        // login string validate
        try {
            if (login.length() > 12 ||
                    login.length() <= 0) {
                throw new ExceptionLength(login.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (char c : login.toCharArray()) {
                for (int n : NUMBERS) {
                    if (Integer.parseInt(String.valueOf(c)) == n)
                        throw new ExceptionNumber(n);
                }
            }
        } catch (NumberFormatException | ExceptionNumber e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean passwordValidate(String password){
        // password string validate
        try {
            if (password.length() > 20 ||
                    password.length() < 8) {
                throw new ExceptionLength(password.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int numbersCount = 0;
            for (char c : password.toCharArray()) {
                for (int n : NUMBERS) {
                    if (Integer.parseInt(String.valueOf(c)) == n)
                        numbersCount++;
                }
            }
            if (numbersCount < 2)
                throw new ExceptionPassNumber(numbersCount);
        } catch (NumberFormatException | ExceptionPassNumber e) {
            e.printStackTrace();
        }
        return true;
    }
}