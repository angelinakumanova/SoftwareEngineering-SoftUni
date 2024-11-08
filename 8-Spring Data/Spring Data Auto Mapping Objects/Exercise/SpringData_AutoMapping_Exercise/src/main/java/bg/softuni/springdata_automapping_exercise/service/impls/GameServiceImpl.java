package bg.softuni.springdata_automapping_exercise.service.impls;

import bg.softuni.springdata_automapping_exercise.data.entities.Game;
import bg.softuni.springdata_automapping_exercise.data.repositories.GameRepository;
import bg.softuni.springdata_automapping_exercise.service.GameService;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.utils.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserService userService;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService, ValidatorUtil validatorUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public String addGame(GameCreateDto gameCreateDto) {
        String validation = validateCurrentUser();
        if (validation != null) return validation;

        String gameValidation = validateGame(gameCreateDto);
        if (gameValidation != null) return gameValidation;

        Game game = modelMapper.map(gameCreateDto, Game.class);
        gameRepository.saveAndFlush(game);

        return String.format("Successfully added game: %s", game.getTitle());
    }



    @Override
    public String editGame(Long id) {
        String validation = validateCurrentUser();
        if (validation != null) return validation;

        String gameValidation = validateGame(gameCreateDto);
        if (gameValidation != null) return gameValidation;

        Game game = modelMapper.map(gameCreateDto, Game.class);
        gameRepository.saveAndFlush(game);

        return String.format("Successfully edited game: %s", game.getTitle());
    }

    private String validateCurrentUser() {
        if (!userService.isLoggedIn()) {
            return "You are not logged in!";
        }

        if (!userService.isAdmin()) {
            return "You do not have permission!";
        }
        return null;
    }

    private String validateGame(GameCreateDto gameCreateDto) {
        if (!validatorUtil.isValid(gameCreateDto)) {
            return validatorUtil.validate(gameCreateDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        return null;
    }

}
