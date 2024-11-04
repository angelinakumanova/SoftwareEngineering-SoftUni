package com.example.advquerying.service.impls;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.service.ShampooService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;


    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public void getShampoosBySize(String size) {
        shampooRepository.findAllShampoosBySizeOrderById(Size.valueOf(size.toUpperCase()))
                .forEach(System.out::println);
    }

    @Override
    public void getShampoosBySizeOrLabel(String size, Long labelId) {
        shampooRepository.findAllShampoosBySizeOrLabelIdOrderByPrice(Size.valueOf(size.toUpperCase()), labelId)
                .forEach(System.out::println);
    }

    @Override
    public void getShampoosByPrice(BigDecimal price) {
        shampooRepository.findAllShampoosByPriceGreaterThanOrderByPriceDesc(price)
                .forEach(System.out::println);
    }

    @Override
    public int getCountOfShampoosWithPriceLowerThan(BigDecimal price) {
        return shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public void getShampoosByIngredients(List<String> ingredients) {
        shampooRepository.getShampoosByGivenIngredients(ingredients)
                .forEach(System.out::println);
    }
}
