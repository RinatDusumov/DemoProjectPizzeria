package com.example.demo.repository;

import com.example.demo.entity.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaDAO extends JpaRepository<Pizzeria, Integer> {
    Pizzeria findPizzeriaByName(String name);
    Pizzeria findPizzeriaByAddress(String address);
    Pizzeria findPizzeriaByPhoneNumber(String phoneNumber);
}