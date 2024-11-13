package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;

    public CommandLineRunnerImpl(CarService carService) {
        this.carService = carService;
    }


    @Override
    public void run(String... args) throws Exception {
        carService.seedCars();
    }
}
