package com.example.advquerying.service.impls;

import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void getIngredientsStartingWith(String prefix) {
        ingredientRepository.findAllByNameStartingWith(prefix).forEach(System.out::println);
    }

    @Override
    public void getIngredientsByNames(List<String> names) {
        ingredientRepository.findAllByNameInOrderByPrice(names)
                .forEach(System.out::println);
    }

    @Override
    public int deleteIngredientsByName(List<String> names) {
        return ingredientRepository.deleteIngredientsByName(names);
    }

    @Override
    public int updateIngredientsPriceBy10Percent() {
        return ingredientRepository.updateIngredientsByPriceBy10Percent();
    }
}
