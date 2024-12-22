package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.repositories.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
