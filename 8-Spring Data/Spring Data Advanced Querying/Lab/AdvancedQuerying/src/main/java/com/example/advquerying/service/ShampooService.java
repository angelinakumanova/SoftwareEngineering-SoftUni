package com.example.advquerying.service;

import java.math.BigDecimal;

public interface ShampooService {

    void getShampoosBySize(String size);

    void getShampoosBySizeOrLabel(String size, Long labelId);

    void getShampoosByPrice(BigDecimal price);
}
