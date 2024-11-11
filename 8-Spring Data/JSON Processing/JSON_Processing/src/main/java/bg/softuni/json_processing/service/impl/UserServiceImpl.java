package bg.softuni.json_processing.service.impl;

import bg.softuni.json_processing.data.entities.User;
import bg.softuni.json_processing.data.repositories.UserRepository;
import bg.softuni.json_processing.service.UserService;
import bg.softuni.json_processing.service.dtos.UserSeedJsonDto;
import bg.softuni.json_processing.utils.ValidatorUtil;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String USERS_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }


    @Override
    public void seedUsers() throws IOException {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(USERS_PATH)))) {
            UserSeedJsonDto[] usersSeed = gson.fromJson(jsonReader, UserSeedJsonDto[].class);

            for (UserSeedJsonDto userSeed : usersSeed) {
                if (!validatorUtil.isValid(userSeed)) {
                    String errors = validatorUtil.validate(userSeed)
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("\n"));
                    System.out.println(("Validation errors: \n" + errors));
                    continue;
                }

                User user = modelMapper.map(userSeed, User.class);
                userRepository.save(user);
            }

            userRepository.flush();
            System.out.println(userRepository.count() + " Users have been seeded");
        } catch (IOException e) {
            System.out.println("Failed to read users.json");
        }


    }

    @Override
    public boolean isImported() {
        return userRepository.count() > 0;
    }

    @Override
    public User getRandomUser() {
        long id = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(id).orElse(null);
    }
}
