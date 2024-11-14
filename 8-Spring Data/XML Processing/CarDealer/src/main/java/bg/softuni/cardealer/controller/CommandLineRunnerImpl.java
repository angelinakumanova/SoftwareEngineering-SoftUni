package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CustomerService customerService;

    public CommandLineRunnerImpl(CarService carService, SupplierService supplierService, PartService partService, CustomerService customerService) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
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

        if (!customerService.isImported()) {
            customerService.seedCustomers();
        }
    }
}
