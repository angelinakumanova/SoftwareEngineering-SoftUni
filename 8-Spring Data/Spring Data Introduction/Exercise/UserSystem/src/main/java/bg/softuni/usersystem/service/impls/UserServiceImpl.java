package bg.softuni.usersystem.service.impls;

import bg.softuni.usersystem.data.entities.Town;
import bg.softuni.usersystem.data.entities.User;
import bg.softuni.usersystem.data.repositories.UserRepository;
import bg.softuni.usersystem.service.TownService;
import bg.softuni.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final static String USERS_PATH = "src/main/resources/user_data.txt";
    private final UserRepository userRepository;
    private final TownService townService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TownService townService) {
        this.userRepository = userRepository;
        this.townService = townService;
    }

    @Override
    public void seedUsers() throws IOException {
        Files.readAllLines(Path.of(USERS_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                    String[] data = line.split("\\s*,\\s*");

                    String username = data[0];
                    String password = data[1];
                    String email = data[2];
                    LocalDateTime registeredOn = LocalDateTime.parse(data[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    LocalDateTime lastTimeLoggedIn = LocalDateTime.parse(data[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    int age = Integer.parseInt(data[5]);
                    boolean isDeleted = Boolean.parseBoolean(data[6]);
                    Town bornTown = townService.getTownByName(data[7].split("-")[0]);
                    Town currentTown = townService.getTownByName(data[8].split("-")[0]);
                    String firstName = data[9];
                    String lastName = data[10];

                    this.userRepository.saveAndFlush(new User(username, password, email, registeredOn, lastTimeLoggedIn,
                            age, isDeleted, bornTown, currentTown, firstName, lastName));
                });

        System.out.printf("Successfully added %d users.\n", this.userRepository.count());
    }

    @Override
    public boolean isImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public void getUsersByEmailProvider(String emailProvider) {
        userRepository.findByEmailContaining(emailProvider)
                .forEach(user -> System.out.printf("%s -> %s%n", user.getUsername(), user.getEmail()));
    }

    @Transactional
    @Override
    public void removeInactiveUsersAfterGivenTime(LocalDateTime dateTime) {
        userRepository.markUsersAsDeletedBefore(dateTime);

        int deleteCount = userRepository.deleteAllByIsDeletedTrue();

        System.out.printf("%d users removed.\n", deleteCount);
    }
}
