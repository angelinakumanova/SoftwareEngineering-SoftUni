package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.entities.User;
import bg.softuni.pathfinder.web.model.UserLoginModel;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    void loginUser(UserLoginModel user);

    void logoutUser();
}
