package bg.softuni.springdata_automapping_exercise.controller;

import bg.softuni.springdata_automapping_exercise.service.GameService;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameEditDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserLoginDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class AppInitializer implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    public AppInitializer(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = reader.readLine()).equals("stop")) {
            String[] tokens = line.split("\\|");
            String command = tokens[0];

            String output = "";
            switch (command) {
                case "RegisterUser":
                    output = this.userService.registerUser(new UserCreateDto(
                            tokens[1], tokens[2], tokens[3], tokens[4]
                    ));
                    break;
                case "LoginUser":
                    output = this.userService.loginUser(new UserLoginDto(
                            tokens[1], tokens[2]
                    ));
                    break;
                case "Logout":
                    output = this.userService.logout();
                    break;
                case "AddGame":
                    output = this.gameService.addGame(new GameCreateDto(
                            tokens[1], new BigDecimal(tokens[2]), Double.parseDouble(tokens[3]), tokens[4],
                            tokens[5], tokens[6], LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ));
                    break;
                case "EditGame":
                    GameEditDto gameEditDto = createGameDto(Long.parseLong(tokens[1]),
                            Arrays.stream(tokens).skip(2).toArray(String[]::new));
                    output = this.gameService.editGame(gameEditDto);
                    break;
                case "DeleteGame":
                    long id = Long.parseLong(tokens[1]);
                    output = this.gameService.deleteGame(id);
                    break;
                case "AllGames":
                    output = this.gameService.getAllGames();
                    break;
                case "DetailsGame":
                    output = this.gameService.getGameDetails(tokens[1]);
                    break;
                case "OwnedGames":
                    output = this.gameService.getOwnedGames();
                    break;
                case "AddItem":
                    output = this.gameService.addItem(tokens[1]);
                    break;
                case "RemoveItem":
                    output = this.gameService.removeItem(tokens[1]);
                    break;
                case "BuyItem":
                    output = this.gameService.buyItem();
                    break;
            }


            System.out.println(output);
        }
    }

    private GameEditDto createGameDto(Long id, String[] array) {
        GameEditDto gameEditDto = new GameEditDto();
        gameEditDto.setId(id);

        for (String value : array) {
            String[] split = value.split("=");
            String field = split[0];

            switch (field) {
                case "title":
                    gameEditDto.setTitle(split[1]);
                    break;
                case "price":
                    gameEditDto.setPrice(new BigDecimal(split[1]));
                    break;
                case "size":
                    gameEditDto.setSize(Double.parseDouble(split[1]));
                    break;
                case "trailer":
                    gameEditDto.setTrailer(split[1]);
                    break;
                case "imageThumbnail":
                    gameEditDto.setImageThumbnail(split[1]);
                    break;
                case "description":
                    gameEditDto.setDescription(split[1]);
                    break;
                case "releaseDate":
                    gameEditDto.setReleaseDate(LocalDate.parse(split[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
            }

        }

        return gameEditDto;
    }
}
