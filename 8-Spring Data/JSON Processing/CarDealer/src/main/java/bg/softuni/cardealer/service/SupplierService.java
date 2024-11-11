package bg.softuni.cardealer.service;


import bg.softuni.cardealer.data.entities.Supplier;

public interface SupplierService {
    void seedSuppliers();

    boolean isImported();

    Supplier getRandomSupplier();
}
