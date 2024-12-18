package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.entities.Role;
import bg.softuni.pathfinder.data.entities.User;
import bg.softuni.pathfinder.data.enums.UserRoles;
import bg.softuni.pathfinder.data.repositories.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.model.UserLoginModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void loginUser(UserLoginModel user) {
        if (!isLoggedIn()) setCurrentUser(findByUsernameAndPassword(user.getUsername(), user.getPassword()).get());
    }

    @Override
    public boolean isLoggedIn() {
        return getCurrentUser() != null;
    }

    @Override
    @Transactional
    public boolean isAdmin() {
        if (currentUser != null) {
            return getCurrentUser().getRoles()
                    .stream()
                    .anyMatch(r -> r.getName().equals(UserRoles.ADMIN));
        }

        return false;
    }

    @Override
    public void logoutUser() {
        setCurrentUser(null);
    }

    private void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    private User getCurrentUser() {
        return currentUser;
    }
}
