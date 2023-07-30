package com.example.demo.controller;

import com.example.demo.entity.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaControllerTest {
    private Pizza pizza;

    @BeforeEach
    public void setUp() {
        pizza = new Pizza("Margarita", 30,
                "mozzarella cheese, tomatoes, basil", 40.23);
    }

    @Test
    void getPizzaByName() {
        assertEquals("Margarita", pizza.getName());
    }

    @Test
    void getPizzaByDiameter() {
        assertEquals(30, pizza.getDiameter());
    }

    @Test
    void getPizzaByPrice() {
        assertEquals(40.23, pizza.getPrice());
    }

    @Test
    void updatePizza() {
        pizza = new Pizza("Carbonara", 15,
                "bacon, italian herbs, tomato paste", 27.30);
        assertEquals("Carbonara", pizza.getName());
    }
}