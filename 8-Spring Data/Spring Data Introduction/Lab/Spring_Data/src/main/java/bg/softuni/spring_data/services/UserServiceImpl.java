package bg.softuni.spring_data.services;

import bg.softuni.spring_data.models.Account;
import bg.softuni.spring_data.models.User;
import bg.softuni.spring_data.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

    @Override
    public User get(int id) {
        return this.userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    @Override
    public void addAccountToUser(int userId, BigDecimal initialBalance) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Account account = new Account();
        account.setBalance(initialBalance);
        user.addAccount(account);

        userRepository.save(user);
    }


}
