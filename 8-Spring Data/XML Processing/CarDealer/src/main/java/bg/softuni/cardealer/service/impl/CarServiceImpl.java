package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Car;
import bg.softuni.cardealer.data.repositories.CarRepository;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.dtos.CarImportXmlDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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
    public void seedCars() throws IOException {
        CarImportXmlDto[] cars = xmlMapper.readValue(new File(CARS_XML_PATH), CarImportXmlDto[].class);


        for (CarImportXmlDto car : cars) {
            Car carDb = this.modelMapper.map(car, Car.class);
//            carDb.setParts(partService.getRandomParts());
            carRepository.save(carDb);
        }

        carRepository.flush();
        System.out.println(carRepository.count() + " Cars have been saved!");

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
//        List<CarByMakeDto> cars = carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
//                .stream()
//                .map(c -> modelMapper.map(c, CarByMakeDto.class))
//                .toList();
//
//        String json = gson.toJson(cars);
//        Path path = Path.of("src/main/resources/files/cars-by-make.json");
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            writer.write(json);
//        } catch (IOException e) {
//            System.out.println("Failed to write cars-by-make.json!");
//        }


    }

    @Override
    public void getAllCarsAndPartsJson() {
//        List<CarPartsListDto> list = carRepository.getAllBy()
//                .stream()
//                .map(c -> {
//                    CarListDto car = modelMapper.map(c, CarListDto.class);
//                    List<PartsListDto> parts = c.getParts()
//                            .stream()
//                            .map(p -> modelMapper.map(p, PartsListDto.class))
//                            .toList();
//
//                    CarPartsListDto carPartsListDto = new CarPartsListDto();
//                    carPartsListDto.setCar(car);
//                    carPartsListDto.setParts(parts);
//
//                    return carPartsListDto;
//                }).toList();
//        String json = gson.toJson(list);
//        Path path = Path.of("src/main/resources/files/cars-and-parts.json");
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            writer.write(json);
//        } catch (IOException e) {
//            System.out.println("Failed to write cars-and-parts.json!");
//        }
    }

}
