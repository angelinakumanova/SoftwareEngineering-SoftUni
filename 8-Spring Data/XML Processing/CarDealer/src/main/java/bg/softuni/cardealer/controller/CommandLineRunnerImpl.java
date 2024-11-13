package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final SupplierService supplierService;
    private final PartService partService;

    public CommandLineRunnerImpl(CarService carService, SupplierService supplierService, PartService partService) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!supplierService.isImported()) {
            supplierService.seedSuppliers();
        }

        if (!partService.isImported()) {
            partService.seedParts();
        }
//        carService.seedCars();
    }
}
