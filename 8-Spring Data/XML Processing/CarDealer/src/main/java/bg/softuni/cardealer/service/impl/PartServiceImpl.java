package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Part;
import bg.softuni.cardealer.data.repositories.PartRepository;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import bg.softuni.cardealer.service.dtos.PartImportXmlDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
    private final static String PARTS_XML_PATH = "src/main/resources/files/parts.xml";

    private final PartRepository partRepository;
    private final SupplierService supplierService;

    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper, XmlMapper xmlMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.xmlMapper = xmlMapper;
    }


    @Override
    public void seedParts() {
        try {
            PartImportXmlDto[] parts = xmlMapper.readValue(new File(PARTS_XML_PATH), PartImportXmlDto[].class);

            Arrays.stream(parts)
                    .map(p -> modelMapper.map(p, Part.class))
                    .peek(p -> p.setSupplier(supplierService.getRandomSupplier()))
                    .forEach(partRepository::save);

            partRepository.flush();
            System.out.println(partRepository.count() + " Parts seeded successfully!");
        } catch (IOException e) {
            System.err.println("Error reading parts from XML file: " + e.getMessage());
        }
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
