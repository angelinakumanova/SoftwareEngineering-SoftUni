package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
