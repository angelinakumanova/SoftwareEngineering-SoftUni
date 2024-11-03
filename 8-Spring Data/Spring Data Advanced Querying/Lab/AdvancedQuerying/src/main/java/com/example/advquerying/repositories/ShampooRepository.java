package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    Set<Shampoo> getShampoosBySizeOrderById(Size size);
}
