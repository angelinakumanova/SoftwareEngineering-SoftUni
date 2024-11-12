package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;

    public ConsoleLineRunner(SupplierService supplierService, PartService partService, CarService carService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!supplierService.isImported()) {
            supplierService.seedSuppliers();
        }

        if (!partService.isImported()) {
            partService.seedParts();
        }

        if (!carService.isImported()) {
            carService.seedCars();
        }
    }
}
