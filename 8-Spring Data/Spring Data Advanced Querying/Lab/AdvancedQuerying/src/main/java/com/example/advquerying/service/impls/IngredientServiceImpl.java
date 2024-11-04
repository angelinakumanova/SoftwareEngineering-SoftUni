package com.example.advquerying.service.impls;

import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.service.IngredientService;
import org.springframework.stereotype.Service;

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
}
