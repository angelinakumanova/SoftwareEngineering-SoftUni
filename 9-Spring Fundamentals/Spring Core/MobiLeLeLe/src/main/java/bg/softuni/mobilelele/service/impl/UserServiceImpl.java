package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.entities.User;
import bg.softuni.mobilelele.data.repositories.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.web.model.UserRegisterModel;
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
    public void registerUser(UserRegisterModel userRegisterModel) {
        User mappedUser = this.modelMapper.map(userRegisterModel, User.class);
        this.userRepository.saveAndFlush(mappedUser);
        System.out.println("User " + userRegisterModel.getUsername() + " was successfully registered!");
    }
}
