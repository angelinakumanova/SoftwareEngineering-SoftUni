package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.config.CurrentUser;
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
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
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
        if (!this.currentUser.isLoggedIn()) this.currentUser
                .setUser(findByUsernameAndPassword(user.getUsername(), user.getPassword()).get());
    }

    @Override
    public void logoutUser() {
        this.currentUser.setUser(null);
    }

}
