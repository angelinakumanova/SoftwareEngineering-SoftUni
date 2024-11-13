package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Part;
import bg.softuni.cardealer.data.repositories.PartRepository;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
    private final static String PARTS_JSON_PATH = "src/main/resources/files/parts.json";

    private final PartRepository partRepository;
    private final SupplierService supplierService;

    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedParts() {
//        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(PARTS_JSON_PATH)))) {
//            CreatePartJsonDto[] parts = gson.fromJson(jsonReader, CreatePartJsonDto[].class);
//
//            for (CreatePartJsonDto part : parts) {
//                Part partDb = modelMapper.map(part, Part.class);
//                partDb.setSupplier(supplierService.getRandomSupplier());
//                partRepository.save(partDb);
//            }
//
//            partRepository.flush();
//            System.out.println(partRepository.count() + " Parts seeded successfully!");
//        } catch (IOException e) {
//            System.out.println("Failed to read parts.json");
//        }
    }

    @Override
    public boolean isImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        int number = ThreadLocalRandom.current().nextInt(3, 6);

        for (int i = 0; i < number; i++) {
            Long id = ThreadLocalRandom.current().nextLong(1, this.partRepository.count() + 1);
            parts.add(partRepository.findById(id).get());
        }

        return parts;
    }
}
