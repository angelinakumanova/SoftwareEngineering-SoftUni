package bg.softuni.smartwalletapp.user.service;

import bg.softuni.smartwalletapp.exception.DomainException;
import bg.softuni.smartwalletapp.subscription.model.Subscription;
import bg.softuni.smartwalletapp.subscription.service.SubscriptionService;
import bg.softuni.smartwalletapp.user.model.User;
import bg.softuni.smartwalletapp.user.model.UserRole;
import bg.softuni.smartwalletapp.user.repository.UserRepository;
import bg.softuni.smartwalletapp.wallet.model.Wallet;
import bg.softuni.smartwalletapp.wallet.service.WalletService;
import bg.softuni.smartwalletapp.web.dto.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final WalletService walletService;
    private final PasswordEncoder passwordEncoder;
    private final SubscriptionService subscriptionService;

    public UserService(UserRepository userRepository, WalletService walletService, PasswordEncoder passwordEncoder, SubscriptionService subscriptionService) {
        this.userRepository = userRepository;
        this.walletService = walletService;
        this.passwordEncoder = passwordEncoder;
        this.subscriptionService = subscriptionService;
    }

    @Transactional
    public User register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.getByUsername(registerRequest.getUsername());

        if (optionalUser.isPresent()) {
            throw new DomainException("Username [%s] is already in use".formatted(registerRequest.getUsername()));
        }

        User user = this.userRepository.save(initializeUser(registerRequest));

        Wallet newWallet = this.walletService.createNewWallet(user);
        user.setWallets(List.of(newWallet));

        Subscription defaultSubscription = subscriptionService.createDefaultSubscription(user);
        user.setSubscriptions(List.of(defaultSubscription));


        log.info("Successfully create new user account for username [%s] and id [%s]".formatted(user.getUsername(), user.getId()));

        return user;
    }

    private User initializeUser(RegisterRequest registerRequest) {
        LocalDateTime now = LocalDateTime.now();

        return User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .country(registerRequest.getCountry())
                .isActive(true)
                .role(UserRole.USER)
                .createdOn(now)
                .updatedOn(now)
                .build();
    }
}
