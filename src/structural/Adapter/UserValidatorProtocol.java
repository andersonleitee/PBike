package structural.Adapter;

import model.User.User;

public interface UserValidatorProtocol {
     boolean validateUser(User user);

     boolean loginValidate(String login);

     boolean passwordValidate(String password);
}
