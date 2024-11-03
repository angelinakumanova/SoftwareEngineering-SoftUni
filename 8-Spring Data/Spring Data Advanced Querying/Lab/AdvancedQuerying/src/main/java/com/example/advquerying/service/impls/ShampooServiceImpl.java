package com.example.advquerying.service.impls;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.service.ShampooService;
import org.springframework.stereotype.Service;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;


    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public void getShampoosBySize(String size) {
        shampooRepository.getShampoosBySizeOrderById(Size.valueOf(size.toUpperCase()))
                .forEach(shampoo -> System.out.printf("%s %s %.2f%n",
                        shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice()));
    }
}
