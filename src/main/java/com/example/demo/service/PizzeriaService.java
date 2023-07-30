package com.example.demo.service;

import com.example.demo.entity.Pizzeria;

import java.util.List;

public interface PizzeriaService {
    List<Pizzeria> getAllPizzerias();
    Pizzeria savePizzeria (Pizzeria pizzeria);
    Pizzeria getPizzeriaById (int id);
    Pizzeria getPizzeriaByName(String name);
    Pizzeria getPizzeriaByAddress(String address);
    Pizzeria getPizzeriaByPhoneNumber(String phoneNumber);
    void deletePizzeriaById (int id);
}