package model.User;

import structural.Factory.Creator;
import structural.Factory.Entity;

public class UserCreator extends Creator {
    private String login, password;

    @Override
    public Entity factoryMethod() {
        User u = new User();
        u.setLogin(login);
        u.setPassword(password);

        return u;
    }

    public void setLoginAndPassword(String login, String password){
        this.login = login;
        this.password = password;
    }
}