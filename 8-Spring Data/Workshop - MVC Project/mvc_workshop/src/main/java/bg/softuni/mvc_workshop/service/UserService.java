package bg.softuni.mvc_workshop.service;

import bg.softuni.mvc_workshop.web.models.UserLoginModel;
import bg.softuni.mvc_workshop.web.models.UserRegisterModel;

public interface UserService {
    boolean validateRegisterModel(UserRegisterModel userRegisterModel);

    void registerUser(UserRegisterModel userRegisterModel);

    boolean loggedIn(UserLoginModel userLoginModel);
}
