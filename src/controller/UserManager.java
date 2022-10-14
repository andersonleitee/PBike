package controller;

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
        if(login.length() > 12 ||
                login.length() <= 0){
            return false;
        }

        for(char c : login.toCharArray()){
            for(int n : NUMBERS) {
                if (Integer.parseInt(String.valueOf(c)) == n)
                    return false;
            }
        }

        return true;
    }

    private boolean passwordValidate(String password){
        // password string validate
        if(password.length() > 20 ||
                password.length() < 8){
            return false;
        }

        int numbersCount = 0;
        for(char c : password.toCharArray()) {
            for (int n : NUMBERS) {
                if (Integer.parseInt(String.valueOf(c)) == n)
                    numbersCount++;
            }
        }
        if(numbersCount < 2)
            return false;

        return true;
    }
}
