package model.User;

import structure.Factory.Entity;

public class User implements Entity {
    private String login;
    private String password;

    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "login='" + login + '\'' + "\n" +
                ", password='" + password + '\'' + "\n"
                ;
    }
}
