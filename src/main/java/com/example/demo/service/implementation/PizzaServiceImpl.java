package com.example.demo.service.implementation;

import com.example.demo.exception_handling.NoSuchPizzaException;
import com.example.demo.entity.Pizza;
import com.example.demo.repository.PizzaDAO;
import com.example.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaDAO pizzaDAO;
    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaDAO.findAll();
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return pizzaDAO.save(pizza);
    }

    @Override
    public Pizza getPizzaById(int id) {
        Pizza pizza = null;
        Optional<Pizza> optional = pizzaDAO.findById(id);
        if(optional.isPresent()) {
            pizza = optional.get();
        } else {
            throw new NoSuchPizzaException("There is no pizza with id = " +
                    id + " in Database");
        }
        return pizza;
    }

    @Override
    public Pizza getPizzaByName(String name) {
        Pizza pizza = null;
        Optional<Pizza> optional = Optional.ofNullable(pizzaDAO.findPizzaByName(name));
        if (optional.isPresent()) {
            pizza = optional.get();
        } else {
            throw new NoSuchPizzaException("There is no pizza with name = " +
                    name + " in Database");
        }
        return pizza;
    }

    @Override
    public List<Pizza> getPizzaByDiameter(Integer diameter) {
        List<Pizza> pizzaList = pizzaDAO.findPizzaByDiameter(diameter);
        if (pizzaList == null) {
            throw new NoSuchPizzaException("There is no pizza with diameter = " +
                    diameter + " in Database");
        }
        return pizzaList;
    }

    @Override
    public Pizza getPizzaByIngredients(String ingredients) {
        Pizza pizza = null;
        Optional<Pizza> optional = Optional.ofNullable(pizzaDAO.findPizzaByIngredients(ingredients));
        if (optional.isPresent()) {
            pizza = optional.get();
        } else {
            throw new NoSuchPizzaException("There is no pizza with ingredients = " +
                    ingredients + " in Database");
        }
        return pizza;
    }

    @Override
    public List<Pizza> getPizzaByPrice(Double price) {
        List<Pizza> pizzaList = pizzaDAO.findPizzaByPrice(price);
        if (pizzaList == null) {
            throw new NoSuchPizzaException("There is no pizza with price = " +
                    price + " in Database");
        }
        return pizzaList;
    }

    @Override
    public void deletePizzaById(int id) {
        Pizza pizza = null;
        Optional<Pizza> optional = pizzaDAO.findById(id);
        if (optional.isPresent()) {
            pizza = optional.get();
            pizza.setIsRemote(true);
            savePizza(pizza);
        } else {
            throw new NoSuchPizzaException("There is no pizza with id = " +
                    id + " in Database");
        }
    }
}