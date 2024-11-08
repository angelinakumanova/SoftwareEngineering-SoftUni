package bg.softuni.springdata_automapping_exercise.service;

import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;

public interface UserService {

    public String registerUser(UserCreateDto userCreateDto);
}
