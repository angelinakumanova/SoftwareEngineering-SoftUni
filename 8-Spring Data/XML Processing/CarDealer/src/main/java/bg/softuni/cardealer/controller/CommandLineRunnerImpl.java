package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final SupplierService supplierService;

    public CommandLineRunnerImpl(CarService carService, SupplierService supplierService) {
        this.carService = carService;
        this.supplierService = supplierService;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!supplierService.isImported()) {
            supplierService.seedSuppliers();
        }
//        carService.seedCars();
    }
}
