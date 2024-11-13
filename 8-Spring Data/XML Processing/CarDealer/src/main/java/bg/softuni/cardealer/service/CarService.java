package bg.softuni.cardealer.service;

import bg.softuni.cardealer.data.entities.Car;

import java.io.IOException;

public interface CarService {
    void seedCars() throws IOException;

    boolean isImported();

    Car getRandomCar();

    void getToyotaCarsJson();

    void getAllCarsAndPartsJson();
}
