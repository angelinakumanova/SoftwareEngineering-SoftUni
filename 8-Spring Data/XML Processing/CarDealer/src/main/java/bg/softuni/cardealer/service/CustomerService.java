package bg.softuni.cardealer.service;

import bg.softuni.cardealer.data.entities.Customer;

public interface CustomerService {
    void seedCustomers();

    boolean isImported();

    Customer getRandomCustomer();

    void getOrderedCustomersXml();

    void getTotalSalesByCustomerJson();
}
