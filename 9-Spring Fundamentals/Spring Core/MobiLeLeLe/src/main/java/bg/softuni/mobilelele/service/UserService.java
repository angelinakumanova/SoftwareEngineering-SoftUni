package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.web.model.UserLoginModel;
import bg.softuni.mobilelele.web.model.UserRegisterModel;

public interface UserService {

    void registerUser(UserRegisterModel userRegisterModel);

    boolean exists(UserLoginModel userLoginModel);

    boolean login(UserLoginModel userLoginModel);
}
