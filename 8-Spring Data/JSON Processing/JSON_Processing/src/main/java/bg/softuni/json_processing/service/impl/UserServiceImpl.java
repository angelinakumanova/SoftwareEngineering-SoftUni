package bg.softuni.json_processing.service.impl;

import bg.softuni.json_processing.data.repositories.UserRepository;
import bg.softuni.json_processing.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
