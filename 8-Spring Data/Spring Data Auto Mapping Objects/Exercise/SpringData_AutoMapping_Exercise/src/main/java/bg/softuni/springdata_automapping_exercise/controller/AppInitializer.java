package bg.softuni.springdata_automapping_exercise.controller;

import bg.softuni.springdata_automapping_exercise.service.UserService;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.UserLoginDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class AppInitializer implements CommandLineRunner {

    private final UserService userService;

    public AppInitializer(UserService userService) {
        this.userService = userService;
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
            }


            System.out.println(output);
        }
    }
}
