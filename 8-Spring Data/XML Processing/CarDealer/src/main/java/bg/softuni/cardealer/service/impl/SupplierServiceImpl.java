package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Supplier;
import bg.softuni.cardealer.data.repositories.SupplierRepository;
import bg.softuni.cardealer.service.SupplierService;
import bg.softuni.cardealer.service.dtos.importDto.SupplierImportXmlDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final static String SUPPLIERS_XML_PATH = "src/main/resources/files/suppliers.xml";

    private final SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlMapper xmlMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void seedSuppliers() {

        try {
            SupplierImportXmlDto[] suppliers = xmlMapper.readValue(new File(SUPPLIERS_XML_PATH), SupplierImportXmlDto[].class);

            Arrays.stream(suppliers)
                    .map(s -> modelMapper.map(s, Supplier.class))
                    .forEach(supplierRepository::save);

            supplierRepository.flush();
            System.out.println("Successfully imported " + supplierRepository.count() + " suppliers");

        } catch (IOException e) {
            System.err.println("Error reading suppliers from XML file: " + e.getMessage());
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

    @Override
    public void getNonAbroadSuppliersJson() {
//        List<NonAbroadSupplierDto> list = supplierRepository.findAllByIsImporterIsFalse()
//                .stream()
//                .map(s -> {
//                    NonAbroadSupplierDto supplier = modelMapper.map(s, NonAbroadSupplierDto.class);
//                    supplier.setPartsCount(s.getParts().size());
//
//                    return supplier;
//                })
//                .toList();
//
//        String json = gson.toJson(list);
//        Path path = Path.of("src/main/resources/files/non-abroad-suppliers.json");
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            writer.write(json);
//        } catch (IOException e) {
//            System.out.println("Failed to write non-abroad-suppliers.json");
//        }

    }
}