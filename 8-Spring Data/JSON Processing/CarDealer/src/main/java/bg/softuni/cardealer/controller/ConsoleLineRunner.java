package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.service.SupplierService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;

    public ConsoleLineRunner(SupplierService supplierService, PartService partService) {
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
    }
}
