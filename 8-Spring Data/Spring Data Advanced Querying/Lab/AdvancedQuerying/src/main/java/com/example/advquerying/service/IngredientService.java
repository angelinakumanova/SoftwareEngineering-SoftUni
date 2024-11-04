package com.example.advquerying.service;

import java.util.List;

public interface IngredientService {
    void getIngredientsStartingWith(String prefix);

    void getIngredientsByNames(List<String> names);

    int deleteIngredientsByName(List<String> names);

    int updateIngredientsPriceBy10Percent();
}
