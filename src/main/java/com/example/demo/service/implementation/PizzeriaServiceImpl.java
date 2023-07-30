package com.example.demo.service.implementation;

import com.example.demo.exception_handling.NoSuchPizzeriaException;
import com.example.demo.entity.Pizzeria;
import com.example.demo.repository.PizzeriaDAO;
import com.example.demo.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    @Autowired
    private PizzeriaDAO pizzeriaDAO;
    @Override
    public List<Pizzeria> getAllPizzerias() {
        return pizzeriaDAO.findAll();
    }

    @Override
    public Pizzeria savePizzeria(Pizzeria pizzeria) {
        return pizzeriaDAO.save(pizzeria);
    }

    @Override
    public Pizzeria getPizzeriaById(int id) {
        Pizzeria pizzeria = null;
        Optional<Pizzeria> optional = pizzeriaDAO.findById(id);
        if (optional.isPresent()) {
            pizzeria = optional.get();
        } else {
            throw new NoSuchPizzeriaException("There is no pizzeria with id = " +
                    id + " in Database");
        }
        return pizzeria;
    }

    @Override
    public Pizzeria getPizzeriaByName(String name) {
        Pizzeria pizzeria = null;
        Optional<Pizzeria> optional = Optional.ofNullable(pizzeriaDAO.findPizzeriaByName(name));
        if (optional.isPresent()) {
            pizzeria = optional.get();
        } else {
            throw new NoSuchPizzeriaException("There is no pizzeria with name = " +
                    name + " in Database");
        }
        return pizzeria;
    }

    @Override
    public Pizzeria getPizzeriaByAddress(String address) {
        Pizzeria pizzeria = null;
        Optional<Pizzeria> optional = Optional.ofNullable(pizzeriaDAO.findPizzeriaByAddress(address));
        if (optional.isPresent()) {
            pizzeria = optional.get();
        } else {
            throw new NoSuchPizzeriaException("There is no pizzeria with address = " +
                    address + " in Database");
        }
        return pizzeria;
    }

    @Override
    public Pizzeria getPizzeriaByPhoneNumber(String phoneNumber) {
        Pizzeria pizzeria = null;
        Optional<Pizzeria> optional = Optional.ofNullable(pizzeriaDAO.findPizzeriaByPhoneNumber(phoneNumber));
        if (optional.isPresent()) {
            pizzeria = optional.get();
        } else {
            throw new NoSuchPizzeriaException("There is no pizzeria with phone number = " +
                    phoneNumber + " in Database");
        }
        return pizzeria;
    }

    @Override
    public void deletePizzeriaById(int id) {
        Pizzeria pizzeria = null;
        Optional<Pizzeria> optional = pizzeriaDAO.findById(id);
        if (optional.isPresent()) {
            pizzeria = optional.get();
            pizzeria.setIsRemote(true);
            savePizzeria(pizzeria);
        } else {
            throw new NoSuchPizzeriaException("There is no order with id = " +
                    id + " in Database");
        }
    }
}