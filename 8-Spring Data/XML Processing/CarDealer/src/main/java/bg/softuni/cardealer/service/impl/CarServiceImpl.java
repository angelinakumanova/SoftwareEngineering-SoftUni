package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Car;
import bg.softuni.cardealer.data.repositories.CarRepository;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.dtos.exportDto.carsAndParts.CarListDto;
import bg.softuni.cardealer.service.dtos.exportDto.carsAndParts.CarPartsListDto;
import bg.softuni.cardealer.service.dtos.exportDto.carsAndParts.CarsAndPartsExportDto;
import bg.softuni.cardealer.service.dtos.exportDto.carsAndParts.PartsListDto;
import bg.softuni.cardealer.service.dtos.exportDto.carsMake.CarByMakeDto;
import bg.softuni.cardealer.service.dtos.exportDto.carsMake.CarsMakeExportDto;
import bg.softuni.cardealer.service.dtos.importDto.CarImportXmlDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarServiceImpl implements CarService {
    private final static String CARS_XML_PATH = "src/main/resources/files/cars.xml";

    private final CarRepository carRepository;
    private final PartService partService;

    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;

    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, XmlMapper xmlMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void seedCars() {
        try {
            CarImportXmlDto[] cars = xmlMapper.readValue(new File(CARS_XML_PATH), CarImportXmlDto[].class);

            Arrays.stream(cars)
                    .map(carDto -> this.modelMapper.map(carDto, Car.class))
                    .peek(carDb -> carDb.setParts(partService.getRandomParts()))
                    .forEach(carRepository::save);

            carRepository.flush();
            System.out.println(carRepository.count() + " Cars have been saved!");

        } catch (IOException e) {
            System.err.println("Error reading cars from XML file: " + e.getMessage());
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
    public void getToyotaCarsXml() {
        List<CarByMakeDto> cars = carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(c -> modelMapper.map(c, CarByMakeDto.class))
                .toList();

        CarsMakeExportDto carsMakeExportDto = new CarsMakeExportDto(cars);
        String path = "src/main/resources/files/cars-by-make.xml";

        try {
            xmlMapper.writeValue(new File(path), carsMakeExportDto);
        } catch (IOException e) {
            System.err.println("Error writing cars to JSON file: " + e.getMessage());
        }

    }

    @Override
    public void getAllCarsAndPartsJson() {
        List<CarPartsListDto> list = carRepository.getAllBy()
                .stream()
                .map(c -> {
                    CarListDto car = modelMapper.map(c, CarListDto.class);
                    List<PartsListDto> parts = c.getParts()
                            .stream()
                            .map(p -> modelMapper.map(p, PartsListDto.class))
                            .toList();

                    CarPartsListDto carPartsListDto = new CarPartsListDto();
                    carPartsListDto.setCar(car);
                    carPartsListDto.setParts(parts);

                    return carPartsListDto;
                }).toList();

        CarsAndPartsExportDto carsAndPartsExportDto = new CarsAndPartsExportDto(list);
        String path = "src/main/resources/files/cars-and-parts.xml";

        try {
            xmlMapper.writeValue(new File(path), carsAndPartsExportDto);
        } catch (IOException e) {
            System.err.println("Error writing cars to XML file: " + e.getMessage());
        }
    }

}
