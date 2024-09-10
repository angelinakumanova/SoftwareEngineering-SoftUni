package Exams.Exam_20Dec21.HighQualityStructure.christmasRaces;

import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.cars.Car;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.drivers.Driver;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.entities.races.Race;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.io.ConsoleReader;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.io.ConsoleWriter;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories.CarRepository;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories.DriverRepository;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories.RaceRepository;
import Exams.Exam_20Dec21.HighQualityStructure.christmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

//        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();
    }
}
