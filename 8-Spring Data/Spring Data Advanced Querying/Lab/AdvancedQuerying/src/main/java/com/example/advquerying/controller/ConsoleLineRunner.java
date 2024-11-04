package com.example.advquerying.controller;

import com.example.advquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleLineRunner implements CommandLineRunner {

    private final ShampooService shampooService;

    public ConsoleLineRunner(ShampooService shampooService) {
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
//        shampooService.getShampoosBySize("Medium");
//        shampooService.getShampoosBySizeOrLabel("Medium", 10L);
        shampooService.getShampoosByPrice(BigDecimal.valueOf(5));
    }
}
