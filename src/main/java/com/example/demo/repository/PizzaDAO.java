package com.example.demo.repository;

import com.example.demo.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Integer> {
    Pizza findPizzaByName(String name);
    List<Pizza> findPizzaByDiameter(Integer diameter);
    Pizza findPizzaByIngredients(String ingredients);
    List<Pizza> findPizzaByPrice(Double price);
}