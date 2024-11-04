package com.example.advquerying.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    void getShampoosBySize(String size);

    void getShampoosBySizeOrLabel(String size, Long labelId);

    void getShampoosByPrice(BigDecimal price);

    int getCountOfShampoosWithPriceLowerThan(BigDecimal price);

    void getShampoosByIngredients(List<String> ingredients);
}
