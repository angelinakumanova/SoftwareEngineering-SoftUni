package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Car;
import bg.softuni.cardealer.data.repositories.CarRepository;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.dtos.exportDto.CarByMakeDto;
import bg.softuni.cardealer.service.dtos.importDto.CreateCarJsonDto;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarServiceImpl implements CarService {
    private final static String CARS_JSON_PATH = "src/main/resources/files/cars.json";

    private final CarRepository carRepository;
    private final PartService partService;

    private final ModelMapper modelMapper;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCars() {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(CARS_JSON_PATH)))) {
            CreateCarJsonDto[] cars = gson.fromJson(jsonReader, CreateCarJsonDto[].class);

            for (CreateCarJsonDto car : cars) {
                Car carDb = this.modelMapper.map(car, Car.class);
                carDb.setParts(partService.getRandomParts());
                carRepository.save(carDb);
            }

            carRepository.flush();
            System.out.println(carRepository.count() + " Cars have been saved!");
        } catch (IOException e) {
            System.out.println("Failed to read cars.json!");
        }
    }

    @Override
    public boolean isImported() {
        return carRepository.count() > 0;
    }

    @Override
    public Car getRandomCar() {
        long id = ThreadLocalRandom.current().nextLong(1, carRepository.count() + 1);

        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void getToyotaCarsJson() {
        List<CarByMakeDto> cars = carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(c -> modelMapper.map(c, CarByMakeDto.class))
                .toList();

        String json = gson.toJson(cars);
        Path path = Path.of("src/main/resources/files/cars-by-make.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Failed to write cars-by-make.json!");
        }


    }

}
