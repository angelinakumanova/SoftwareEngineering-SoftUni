package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Set;

public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    Set<Shampoo> findAllShampoosBySizeOrderById(Size size);

    Set<Shampoo> findAllShampoosBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    Set<Shampoo> findAllShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
}
