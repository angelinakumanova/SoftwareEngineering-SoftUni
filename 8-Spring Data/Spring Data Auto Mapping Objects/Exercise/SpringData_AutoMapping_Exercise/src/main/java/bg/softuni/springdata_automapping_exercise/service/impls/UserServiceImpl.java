package bg.softuni.springdata_automapping_exercise.service.impls;

import bg.softuni.springdata_automapping_exercise.data.entities.User;
import bg.softuni.springdata_automapping_exercise.data.repositories.UserRepository;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.utils.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Validator validator, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public String registerUser(UserCreateDto userCreateDto) {
        if (!validatorUtil.isValid(userCreateDto)) {
            String errors = validatorUtil.validate(userCreateDto).stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
            return "User validation failed: \n" + errors;
        }

        if (!userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            return "Passwords do not match";
        }

        User user = modelMapper.map(userCreateDto, User.class);
        setRootUserAdmin(user);

        this.userRepository.saveAndFlush(user);
        return String.format("%s was registered.", user.getFullName());
    }

    private void setRootUserAdmin(User user) {
        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        }
    }
}
