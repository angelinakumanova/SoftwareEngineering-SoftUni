package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Car;
import bg.softuni.cardealer.data.entities.Part;
import bg.softuni.cardealer.data.entities.Sale;
import bg.softuni.cardealer.data.repositories.SaleRepository;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.SaleService;
import bg.softuni.cardealer.service.dtos.exportDto.CarDiscountDto;
import bg.softuni.cardealer.service.dtos.exportDto.SaleDiscountDto;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;

    private final ModelMapper modelMapper;
    private final Gson gson;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService, ModelMapper modelMapper, Gson gson) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedSales() {

        for (int i = 0; i < 30; i++) {
            Sale sale = new Sale();
            Car car = carService.getRandomCar();
            while (carBelongsToSale(car)) {
                car = carService.getRandomCar();
            }
            sale.setCar(car);
            sale.setCustomer(customerService.getRandomCustomer());
            sale.setDiscount(getRandomDiscount());


            saleRepository.save(sale);
        }

        saleRepository.flush();
        System.out.println(saleRepository.count() + " Sales have been generated!");
        
    }

    @Override
    public boolean isImported() {
        return saleRepository.count() > 0;
    }

    @Override
    public void getSalesWithAppliedDiscountJson() {
        List<SaleDiscountDto> list = saleRepository.getAllBy()
                .stream()
                .map(s -> {
                    CarDiscountDto car = modelMapper.map(s.getCar(), CarDiscountDto.class);
                    String name = s.getCustomer().getName();
                    Double discount = s.getDiscount() / 100.0;
                    BigDecimal partsTotalPrice = s.getCar().getParts().stream()
                            .map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                    BigDecimal discountPrice = partsTotalPrice.multiply(BigDecimal.valueOf((100 - s.getDiscount()) / 100.0));

                    SaleDiscountDto saleDiscountDto = new SaleDiscountDto();
                    saleDiscountDto.setCar(car);
                    saleDiscountDto.setCustomerName(name);
                    saleDiscountDto.setDiscount(discount);
                    saleDiscountDto.setPrice(partsTotalPrice);
                    saleDiscountDto.setPriceWithDiscount(discountPrice);

                    return saleDiscountDto;
                }).toList();

        String json = gson.toJson(list);
        Path path = Path.of("src/main/resources/files/sales-discount.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Couldn't write sales-discount.json");
        }
    }

    private Integer getRandomDiscount() {
        List<Integer> discounts = List.of(0, 5, 10, 15, 20, 30, 40, 50);
        int position = ThreadLocalRandom.current().nextInt(0, discounts.size());
        
        return discounts.get(position);
    }

    private boolean carBelongsToSale(Car car) {
        Optional<Sale> saleByCarId = this.saleRepository.findSaleByCarId(car.getId());

        return saleByCarId.isPresent();
    }
}
