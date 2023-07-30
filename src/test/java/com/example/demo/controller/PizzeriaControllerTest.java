package com.example.demo.controller;

import com.example.demo.entity.Pizzeria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzeriaControllerTest {
    Pizzeria pizzeria;

    @BeforeEach
    public void setUp() {
        pizzeria = new Pizzeria("Moya Pizzeria",
                "ul.Berlinskaya", "435");
    }

    @Test
    void getPizzeriaByName() {
        assertEquals("Moya Pizzeria", pizzeria.getName());
    }

    @Test
    void getPizzeriaByAddress() {
        assertEquals("ul.Berlinskaya", pizzeria.getAddress());
    }

    @Test
    void getPizzeriaByPhoneNumber() {
        assertEquals(435, pizzeria.getPhoneNumber());
    }

    @Test
    void updatePizzeria() {
        pizzeria = new Pizzeria("Pizza Hut", "ul.Galileo", "333");
        assertEquals("Pizza Hut", pizzeria.getName());
    }
}