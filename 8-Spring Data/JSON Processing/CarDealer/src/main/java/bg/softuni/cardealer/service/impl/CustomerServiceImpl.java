package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Customer;
import bg.softuni.cardealer.data.entities.Part;
import bg.softuni.cardealer.data.repositories.CustomerRepository;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.dtos.exportDto.CustomerSaleDto;
import bg.softuni.cardealer.service.dtos.exportDto.OrderedCustomerDto;
import bg.softuni.cardealer.service.dtos.importDto.CreateCustomerJsonDto;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    @Override
    public void getOrderedCustomersJson() {
        List<OrderedCustomerDto> list = customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(c -> modelMapper.map(c, OrderedCustomerDto.class))
                .toList();

        String json = gson.toJson(list);
        Path filePath = Path.of("src/main/resources/files/ordered-customers.json");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Couldn't write ordered-customers.json");
        }
    }

    @Override
    public void getTotalSalesByCustomerJson() {
        List<CustomerSaleDto> list = customerRepository.getAllByBoughtIsNotEmpty()
                .stream()
                .map(c -> {
                    String name = c.getName();
                    Integer boughtCars = c.getBought().size();
                    BigDecimal spentMoney = c.getBought().stream()
                            .map(s -> s.getCar().getParts()
                                    .stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    CustomerSaleDto customerSaleDto = new CustomerSaleDto();
                    customerSaleDto.setFullName(name);
                    customerSaleDto.setBoughtCars(boughtCars);
                    customerSaleDto.setSpentMoney(spentMoney);

                    return customerSaleDto;
                }).sorted(Comparator.comparing(CustomerSaleDto::getSpentMoney, Comparator.reverseOrder())
                        .thenComparing(CustomerSaleDto::getBoughtCars, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        String json = gson.toJson(list);
        Path path = Path.of("src/main/resources/files/total-sales.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Couldn't write total-sales.json");
        }
    }
}
