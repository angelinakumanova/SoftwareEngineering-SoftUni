package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.data.entities.Car;
import bg.softuni.cardealer.data.entities.Part;
import bg.softuni.cardealer.data.entities.Sale;
import bg.softuni.cardealer.data.repositories.SaleRepository;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.service.SaleService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            sale.setDiscount(getRandomDiscount());
            Car car = carService.getRandomCar();
            while (carBelongsToSale(car)) {
                car = carService.getRandomCar();
            }
            sale.setCar(car);
            sale.setCustomer(customerService.getRandomCustomer());

            saleRepository.save(sale);
        }

        saleRepository.flush();
        System.out.println(saleRepository.count() + " Sales have been generated!");
        
    }

    @Override
    public boolean isImported() {
        return saleRepository.count() > 0;
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
