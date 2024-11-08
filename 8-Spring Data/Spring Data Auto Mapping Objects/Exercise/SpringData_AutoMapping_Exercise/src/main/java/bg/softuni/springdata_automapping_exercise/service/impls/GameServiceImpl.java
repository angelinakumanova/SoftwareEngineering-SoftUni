package bg.softuni.springdata_automapping_exercise.service.impls;

import bg.softuni.springdata_automapping_exercise.data.entities.Game;
import bg.softuni.springdata_automapping_exercise.data.repositories.GameRepository;
import bg.softuni.springdata_automapping_exercise.service.GameService;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameEditDto;
import bg.softuni.springdata_automapping_exercise.utils.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserService userService;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper,
                           UserService userService, ValidatorUtil validatorUtil) {
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
    public String editGame(GameEditDto gameEditDto) {
        String validation = validateCurrentUser();
        if (validation != null) return validation;

        String gameValidation = validateGame(gameEditDto);
        if (gameValidation != null) return gameValidation;

        Optional<Game> optionalGame = this.gameRepository.findById(gameEditDto.getId());

        if (optionalGame.isEmpty()) {
            return String.format("Game with id %s not found", gameEditDto.getId());
        }

        Game game = optionalGame.get();
        setGameProperties(game, gameEditDto);
        this.gameRepository.saveAndFlush(game);

        return String.format("Successfully edited game: %s", game.getTitle());
    }

    private void setGameProperties(Game game, GameEditDto gameEditDto) {
        if (gameEditDto.getTitle() != null) {
            game.setTitle(gameEditDto.getTitle());
        }

        if (gameEditDto.getPrice() != null) {
            game.setPrice(gameEditDto.getPrice());
        }

        if (gameEditDto.getSize() != 0) {
            game.setSize(gameEditDto.getSize());
        }

        if (gameEditDto.getTrailer() != null) {
            game.setTrailer(gameEditDto.getTrailer());
        }

        if (gameEditDto.getImageThumbnail() != null) {
            game.setImageThumbnail(gameEditDto.getImageThumbnail());
        }

        if (gameEditDto.getDescription() != null) {
            game.setDescription(gameEditDto.getDescription());
        }

        if (gameEditDto.getReleaseDate() != null) {
            game.setReleaseDate(gameEditDto.getReleaseDate());
        }

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

    private <E> String validateGame(E e) {
        if (!validatorUtil.isValid(e)) {
            return validatorUtil.validate(e)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        return null;
    }

}
