package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Customer;
import bg.softuni.cardealer.data.repositories.CustomerRepository;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.dtos.CreateCustomerJsonDto;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final String CUSTOMERS_JSON_PATH = "src/main/resources/files/customers.json";

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;


    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public void seedCustomers() {
        try (JsonReader jsonReader = new JsonReader(Files.newBufferedReader(Path.of(CUSTOMERS_JSON_PATH)))) {
            CreateCustomerJsonDto[] customers = gson.fromJson(jsonReader, CreateCustomerJsonDto[].class);

            for (CreateCustomerJsonDto customer : customers) {
                Customer customerDb = modelMapper.map(customer, Customer.class);
                customerRepository.save(customerDb);
            }

            customerRepository.flush();
            System.out.println(customerRepository.count() + " Customers have been saved!");
        } catch (IOException e) {
            System.out.println("Couldn't read customers.json");
        }
    }

    @Override
    public boolean isImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public Customer getRandomCustomer() {
        long id = ThreadLocalRandom.current().nextLong(1, customerRepository.count() + 1);

        return customerRepository.findById(id).orElse(null);
    }
}
