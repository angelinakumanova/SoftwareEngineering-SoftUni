package bg.softuni.springdata_automapping_exercise.service;

import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserLoginDto;

public interface UserService {

    String registerUser(UserCreateDto userCreateDto);

    String loginUser(UserLoginDto userLoginDto);

    boolean isLoggedIn();

    String logout();
}
