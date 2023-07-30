package com.example.demo.service;

import com.example.demo.entity.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getAllPizzas();
    Pizza savePizza (Pizza pizza);
    Pizza getPizzaById (int id);
    Pizza getPizzaByName (String name);
    List<Pizza> getPizzaByDiameter(Integer diameter);
    Pizza getPizzaByIngredients(String ingredients);
    List<Pizza> getPizzaByPrice(Double price);
    void deletePizzaById (int id);
}