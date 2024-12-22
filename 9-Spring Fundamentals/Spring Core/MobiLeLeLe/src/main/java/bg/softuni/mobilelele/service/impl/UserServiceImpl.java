package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.entities.User;
import bg.softuni.mobilelele.data.repositories.UserRepository;
import bg.softuni.mobilelele.service.CurrentUser;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.web.model.UserLoginModel;
import bg.softuni.mobilelele.web.model.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserRegisterModel userRegisterModel) {
        User mappedUser = this.modelMapper.map(userRegisterModel, User.class);
        mappedUser.setPassword(this.passwordEncoder.encode(userRegisterModel.getPassword()));
        this.userRepository.saveAndFlush(mappedUser);
        System.out.println("User " + userRegisterModel.getUsername() + " was successfully registered!");
    }

    @Override
    public boolean exists(UserLoginModel userLoginModel) {
        Optional<User> user = userRepository.findByUsername(userLoginModel.getUsername());

        return user.filter(value -> passwordEncoder
                        .matches(userLoginModel.getPassword(), value.getPassword()))
                .isPresent();

    }

    @Override
    public boolean login(UserLoginModel userLoginModel) {

        if (exists(userLoginModel)) {
            User user = userRepository.findByUsername(userLoginModel.getUsername()).get();
            currentUser.setFullName(user.getFirstName() + " " + user.getLastName());
            currentUser.setUsername(user.getUsername());
            currentUser.setLoggedIn(true);

            return true;
        }

        currentUser.clean();
        return false;
    }
}
