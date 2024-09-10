package Exams.Exam_20Dec21.BusinessLogic.christmasRaces.core;

import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.common.ExceptionMessages;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.common.OutputMessages;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.core.interfaces.Controller;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.cars.Car;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.cars.MuscleCar;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.cars.SportsCar;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.drivers.Driver;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.drivers.DriverImpl;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.races.Race;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.entities.races.RaceImpl;
import Exams.Exam_20Dec21.BusinessLogic.christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driverName));
        }

        this.driverRepository.add(new DriverImpl(driverName));

        return String.format(OutputMessages.DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);
        if (car != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }

        if (type.equals("Muscle")) {
            this.carRepository.add(new MuscleCar(model, horsePower));
        } else if (type.equals("Sports")) {
            this.carRepository.add(new SportsCar(model, horsePower));
        }

        return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        Driver driver = this.driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        int laps = race.getLaps();
        List<Driver> sortedDrivers = race.getDrivers()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(laps), d1.getCar().calculateRacePoints(laps)))
                .collect(Collectors.toList());

        if (sortedDrivers.size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        StringBuilder winners = new StringBuilder();
        winners.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, sortedDrivers.get(0).getName(), raceName))
                .append(System.lineSeparator());
        winners.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, sortedDrivers.get(1).getName(), raceName))
                .append(System.lineSeparator());
        winners.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, sortedDrivers.get(2).getName(), raceName));
        return winners.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);

        if (race != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        this.raceRepository.add(new RaceImpl(name, laps));
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
