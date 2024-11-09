package bg.softuni.springdata_automapping_exercise.service.impls;

import bg.softuni.springdata_automapping_exercise.data.entities.Game;
import bg.softuni.springdata_automapping_exercise.data.repositories.GameRepository;
import bg.softuni.springdata_automapping_exercise.data.repositories.UserRepository;
import bg.softuni.springdata_automapping_exercise.service.GameService;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameEditDto;
import bg.softuni.springdata_automapping_exercise.utils.ValidatorUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    private final Set<Game> games = new HashSet<>();

    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, ModelMapper modelMapper,
                           UserService userService, ValidatorUtil validatorUtil) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
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

    @Override
    public String deleteGame(long id) {
        String validation = validateCurrentUser();
        if (validation != null) return validation;

        Optional<Game> optionalGame = this.gameRepository.findById(id);

        if (optionalGame.isEmpty()) {
            return String.format("Game with id %s not found", id);
        }

        Game game = optionalGame.get();
        this.gameRepository.delete(game);

        return String.format("Successfully deleted game: %s", game.getTitle());
    }

    @Override
    public String getAllGames() {
        return this.gameRepository.findAll().stream()
                .map(g -> String.format("%s %.2f", g.getTitle(), g.getPrice()))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String getGameDetails(String title) {
        Optional<Game> gameByTitle = this.gameRepository.findGameByTitle(title);
        if (gameByTitle.isEmpty()) {
            return "No such game found";
        }

        Game game = gameByTitle.get();

        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s",
                game.getTitle(), game.getPrice(), game.getDescription(),
                game.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Override
    public String getOwnedGames() {
        if (!userService.isLoggedIn()) {
            return "No user logged in";
        }

        List<Game> games = this.userService.getUser().getGames();
        if (games.isEmpty()) {
            return "No owned games.";
        }

        return games.stream().map(Game::getTitle).collect(Collectors.joining("\n"));
    }

    @Override
    public String addItem(String gameTitle) {
        if (!userService.isLoggedIn()) {
            return "No user logged in";
        }

        Optional<Game> optionalGame = gameRepository.findGameByTitle(gameTitle);
        if (optionalGame.isEmpty()) {
            return "No such game found";
        }

        Game game = optionalGame.get();
        if (this.games.contains(game)) {
            return "You have already added this game in the shopping cart.";
        }

        this.games.add(game);
        return String.format("Successfully added game: %s", game.getTitle());
    }

    @Override
    public String removeItem(String title) {
        if (!userService.isLoggedIn()) {
            return "No user logged in";
        }

        Optional<Game> optionalGame = gameRepository.findGameByTitle(title);
        if (optionalGame.isEmpty()) {
            return "No such game";
        }

        Game game = optionalGame.get();
        if (!this.games.contains(game)) {
            return "You have not added this game to the shopping cart.";
        }

        this.games.remove(game);
        return String.format("Successfully removed game: %s", game.getTitle());
    }

    @Override
    public String buyItem() {
        if (!userService.isLoggedIn()) {
            return "No user logged in";
        }

        if (games.isEmpty()) {
            return "No games in shopping cart";
        }

        List<Game> userGames = userService.getUser().getGames();
        Set<Game> alreadyOwnedGames = userGames.stream()
                .filter(games::contains)
                .collect(Collectors.toSet());

        StringBuilder output = new StringBuilder();
        if (!alreadyOwnedGames.isEmpty()) {
            output.append("You already own these games:\n");
            alreadyOwnedGames.forEach(game -> {
                games.remove(game);
                output.append(String.format(" - %s\n", game.getTitle()));
            });
        }

        if (!games.isEmpty()) output.append("You have successfully bought these games:\n");
        games.forEach(game -> {
            userGames.add(game);
            output.append(String.format(" - %s\n", game.getTitle()));
            games.clear();
            userRepository.saveAndFlush(userService.getUser());
        });

        return output.toString().trim();
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
