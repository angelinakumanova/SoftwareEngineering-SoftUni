package bg.softuni.cardealer.service;

import bg.softuni.cardealer.data.entities.Car;

public interface CarService {
    void seedCars();

    boolean isImported();

    Car getRandomCar();

    void getToyotaCarsJson();

    void getAllCarsAndPartsJson();
}
