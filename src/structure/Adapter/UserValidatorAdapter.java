package structure.Adapter;

import infrastructure.ExceptionLength;
import infrastructure.ExceptionNumber;
import infrastructure.ExceptionPassNumber;
import model.User.User;


public class UserValidatorAdapter implements UserValidatorProtocol{
    private final int MAX_NUM = 9;

    @Override
    public boolean validateUser(User user) {
        boolean response = true;

        response = this.loginValidate(user.getLogin()) &&
                this.passwordValidate(user.getPassword());

        return response;
    }

    @Override
    public boolean loginValidate(String login) {
        // login string validate
        try {
            if (login.length() > 12 ||
                    login.length() == 0) {
                throw new ExceptionLength(login.length());
            }

            for (char c : login.toCharArray()) {
                if (Character.isDigit(c))
                    throw new ExceptionNumber(Integer.parseInt(String.valueOf(c)));

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean passwordValidate(String password) {
        // password string validate
        try {
            if (password.length() > 20 ||
                    password.length() < 8) {
                throw new ExceptionLength(password.length());
            }

            int numbersCount = 0;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c))
                    numbersCount++;
            }
            if (numbersCount < 2)
                throw new ExceptionPassNumber(numbersCount);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }





}