package bg.softuni.cardealer.controller;

import bg.softuni.cardealer.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public CommandLineRunnerImpl(CarService carService, SupplierService supplierService, PartService partService, CustomerService customerService, SaleService saleService) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.saleService = saleService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

//        customerService.getOrderedCustomersXml();
//        carService.getToyotaCarsXml();
//        supplierService.getNonAbroadSuppliersXml();
//        carService.getAllCarsAndPartsXml();
//        customerService.getTotalSalesByCustomerXml();
        saleService.getSalesWithAppliedDiscountXml();
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
