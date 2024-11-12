package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Supplier;
import bg.softuni.cardealer.data.repositories.SupplierRepository;
import bg.softuni.cardealer.service.SupplierService;
import bg.softuni.cardealer.service.dtos.importDto.CreateSupplierJsonDto;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final static String SUPPLIERS_JSON_PATH = "src/main/resources/files/suppliers.json";

    private final SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedSuppliers() {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(SUPPLIERS_JSON_PATH)))) {
            CreateSupplierJsonDto[] suppliers = gson.fromJson(jsonReader, CreateSupplierJsonDto[].class);

            for (CreateSupplierJsonDto supplier : suppliers) {
                Supplier supplierDb = modelMapper.map(supplier, Supplier.class);
                supplierRepository.save(supplierDb);
            }

            supplierRepository.flush();
            System.out.println(supplierRepository.count() + " Suppliers have been seeded");
        } catch (IOException e) {
            System.out.println("Failed to read suppliers.json");
        }

    }

    @Override
    public boolean isImported() {
        return this.supplierRepository.count() > 0;
    }

    @Override
    public Supplier getRandomSupplier() {
        Long id = ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1);
        Optional<Supplier> supplier = supplierRepository.findById(id);

        return supplier.get();
    }
}