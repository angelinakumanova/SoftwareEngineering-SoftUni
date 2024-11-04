package com.example.advquerying.controller;

import com.example.advquerying.service.IngredientService;
import com.example.advquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleLineRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
//        shampooService.getShampoosBySize("Medium");
//        shampooService.getShampoosBySizeOrLabel("Medium", 10L);
//        shampooService.getShampoosByPrice(BigDecimal.valueOf(5));
//        ingredientService.getIngredientsStartingWith("M");
//        ingredientService.getIngredientsByNames(List.of("Lavender", "Herbs", "Apple"));
//        System.out.println(shampooService.getCountOfShampoosWithPriceLowerThan(BigDecimal.valueOf(8.5)));
//        shampooService.getShampoosByIngredients(List.of("Berry", "Mineral-Collagen"));
//        shampooService.getShampoosByIngredientsCount(2);
        int deletion = ingredientService.deleteIngredientsByName(List.of("Apple"));
        System.out.println(deletion);
    }




}
