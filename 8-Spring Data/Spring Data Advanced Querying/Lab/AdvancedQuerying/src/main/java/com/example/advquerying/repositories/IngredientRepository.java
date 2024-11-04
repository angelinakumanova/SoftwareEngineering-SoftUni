package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Set<Ingredient> findAllByNameStartingWith(String prefix);

    Set<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    @Query("DELETE Ingredient i WHERE i.name IN :names")
    @Transactional
    @Modifying
    int deleteIngredientsByName(List<String> names);
}
