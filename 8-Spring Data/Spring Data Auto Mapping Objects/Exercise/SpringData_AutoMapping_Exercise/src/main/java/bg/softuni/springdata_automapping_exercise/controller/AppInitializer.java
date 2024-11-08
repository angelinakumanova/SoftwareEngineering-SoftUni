package bg.softuni.springdata_automapping_exercise.controller;

import bg.softuni.springdata_automapping_exercise.service.GameService;
import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserLoginDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                    
                    break;
            }


            System.out.println(output);
        }
    }
}
