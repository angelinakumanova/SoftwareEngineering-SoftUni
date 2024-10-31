package bg.softuni.spring_data.services;

import bg.softuni.spring_data.models.User;
import bg.softuni.spring_data.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void register(User user) {
        if (this.userRepository.existsByUsername(user.getUsername())) {
            System.out.println("User is already registered!");
            return;
        }

        this.userRepository.save(user);
    }


}
