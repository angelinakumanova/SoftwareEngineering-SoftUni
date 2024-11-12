package bg.softuni.cardealer.service;

public interface SaleService {
    void seedSales();

    boolean isImported();

    void getSalesWithAppliedDiscountJson();
}
