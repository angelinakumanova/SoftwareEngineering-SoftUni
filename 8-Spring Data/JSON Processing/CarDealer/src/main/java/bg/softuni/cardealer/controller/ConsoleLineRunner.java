package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public ConsoleLineRunner(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
        
    }

    private void seedDatabase() {
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

        if (!saleService.isImported()) {
            saleService.seedSales();
        }
    }
}
