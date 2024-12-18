package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.entities.User;
import bg.softuni.pathfinder.data.repositories.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.model.UserLoginModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
        if (!isLoggedIn()) setCurrentUser(modelMapper.map(user, User.class));
    }

    @Override
    public boolean isLoggedIn() {
        return getCurrentUser() != null;
    }

    private void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    private User getCurrentUser() {
        return currentUser;
    }
}
