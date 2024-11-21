package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.data.entities.User;
import bg.softuni.mvc_workshop.data.repositories.UserRepository;
import bg.softuni.mvc_workshop.service.UserService;
import bg.softuni.mvc_workshop.web.models.UserLoginModel;
import bg.softuni.mvc_workshop.web.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean validateRegisterModel(UserRegisterModel userRegisterModel) {
        return userRepository.findByUsername(userRegisterModel.getUsername()).isEmpty() &&
                userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword()) &&
                userRepository.findByEmail(userRegisterModel.getEmail()).isEmpty();
    }

    @Override
    public void registerUser(UserRegisterModel userRegisterModel) {
        User mappedUser = modelMapper.map(userRegisterModel, User.class);
        userRepository.saveAndFlush(mappedUser);
    }

    @Override
    public boolean loggedIn(UserLoginModel userLoginModel) {
        return userRepository.findByUsernameAndPassword(userLoginModel.getUsername(), userLoginModel.getPassword()).isPresent();
    }
}
