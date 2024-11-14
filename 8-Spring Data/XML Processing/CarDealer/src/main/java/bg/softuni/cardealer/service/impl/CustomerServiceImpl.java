package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Customer;
import bg.softuni.cardealer.data.repositories.CustomerRepository;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.dtos.exportDto.orderedCustomers.OrderedCustomerDto;
import bg.softuni.cardealer.service.dtos.exportDto.orderedCustomers.OrderedCustomersExportDto;
import bg.softuni.cardealer.service.dtos.importDto.CustomerImportXmlDto;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final String CUSTOMERS_XML_PATH = "src/main/resources/files/customers.xml";

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, XmlMapper xmlMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        configureMappings();
        this.xmlMapper = xmlMapper;
    }


    @Override
    public void seedCustomers() {
        try {
            CustomerImportXmlDto[] customers = xmlMapper.readValue(new File(CUSTOMERS_XML_PATH), CustomerImportXmlDto[].class);

            Arrays.stream(customers).map(c -> modelMapper.map(c, Customer.class)).forEach(customerRepository::save);

            customerRepository.flush();
            System.out.println(customerRepository.count() + " Customers have been saved!");
        } catch (IOException e) {
            System.err.println("Error reading customers from XML file: " + e.getMessage());
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
    public void getOrderedCustomersXml() {
        List<OrderedCustomerDto> list = customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(c -> modelMapper.map(c, OrderedCustomerDto.class))
                .toList();

        OrderedCustomersExportDto orderedCustomersExportDto = new OrderedCustomersExportDto(list);

        String path = "src/main/resources/files/ordered-customers.xml";

        try {
            xmlMapper.writeValue(new File(path), orderedCustomersExportDto);
        } catch (IOException e) {
            System.err.println("Error writing customers to XML file: " + e.getMessage());
        }
    }

    @Override
    public void getTotalSalesByCustomerJson() {
//        List<CustomerSaleDto> list = customerRepository.getAllByBoughtIsNotEmpty()
//                .stream()
//                .map(c -> {
//                    String name = c.getName();
//                    Integer boughtCars = c.getBought().size();
//                    BigDecimal spentMoney = c.getBought().stream()
//                            .map(s -> s.getCar().getParts()
//                                    .stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
//                            .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//                    CustomerSaleDto customerSaleDto = new CustomerSaleDto();
//                    customerSaleDto.setFullName(name);
//                    customerSaleDto.setBoughtCars(boughtCars);
//                    customerSaleDto.setSpentMoney(spentMoney);
//
//                    return customerSaleDto;
//                }).sorted(Comparator.comparing(CustomerSaleDto::getSpentMoney, Comparator.reverseOrder())
//                        .thenComparing(CustomerSaleDto::getBoughtCars, Comparator.reverseOrder()))
//                .collect(Collectors.toList());
//
//        String json = gson.toJson(list);
//        Path path = Path.of("src/main/resources/files/total-sales.json");
//
//        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
//            writer.write(json);
//        } catch (IOException e) {
//            System.out.println("Couldn't write total-sales.json");
//        }
    }

    private void configureMappings() {
        Converter<String, LocalDate> toLocalDate = context ->
                LocalDate.parse(context.getSource(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        PropertyMap<CustomerImportXmlDto, Customer> propertyMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(toLocalDate).map(source.getBirthDate()).setBirthDate(null);
            }
        };

        modelMapper.addMappings(propertyMap);
    }
}
