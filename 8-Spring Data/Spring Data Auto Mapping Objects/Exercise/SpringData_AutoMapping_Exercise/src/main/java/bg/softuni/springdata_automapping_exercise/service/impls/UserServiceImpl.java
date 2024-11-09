package bg.softuni.springdata_automapping_exercise.service.impls;

import bg.softuni.springdata_automapping_exercise.data.entities.User;
import bg.softuni.springdata_automapping_exercise.data.repositories.UserRepository;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserLoginDto;
import bg.softuni.springdata_automapping_exercise.utils.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    private User currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Validator validator, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public String registerUser(UserCreateDto userCreateDto) {
        if (!validatorUtil.isValid(userCreateDto)) {
            return validatorUtil.validate(userCreateDto).stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            return "Email address already in use";
        }

        if (!userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            return "Passwords do not match";
        }

        User user = modelMapper.map(userCreateDto, User.class);
        setRootUserAdmin(user);


        this.userRepository.saveAndFlush(user);
        return String.format("%s was registered.", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (user.isEmpty()) {
            return "Invalid email or password";
        }

        this.currentUser = user.get();

        return String.format("%s has successfully logged in.", this.currentUser.getFullName());
    }

    @Override
    public boolean isLoggedIn() {
        return this.currentUser != null;
    }

    @Override
    public String logout() {
        if (isLoggedIn()) {
            String output = String.format("%s has been logged out.", this.currentUser.getFullName());
            this.currentUser = null;
            return output;
        }


        return "No user logged in.";
    }

    @Override
    public boolean isAdmin() {
        return this.currentUser.isAdmin();
    }

    @Override
    public User getUser() {
        return this.currentUser;
    }


    private void setRootUserAdmin(User user) {
        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        }
    }


}
