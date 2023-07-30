package com.example.demo.controller;

import com.example.demo.entity.Pizza;
import com.example.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    /**
     * gets all objects
     * @return all objects
     */
    @GetMapping("/pizzas")
    public ResponseEntity<List<Pizza>> getAllPizzas() {

        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    /**
     * gets an object by id
     * @param id
     * @return object of the specified id
     */
    @GetMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable int id) {
        return ResponseEntity.ok(pizzaService.getPizzaById(id));
    }

    /**
     * gets an object by name
     * @param name
     * @return object of the specified name
     */
    @GetMapping("/pizzas/{name}")
    public ResponseEntity<Pizza> getPizzaByName(@PathVariable String name) {
        return ResponseEntity.ok(pizzaService.getPizzaByName(name));
    }

    /**
     * gets an object by diameter
     * @param diameter
     * @return object of the specified diameter
     */
    @GetMapping("/pizzas/{diameter}")
    public ResponseEntity<List<Pizza>> getPizzaByDiameter(@PathVariable Integer diameter) {
        return ResponseEntity.ok(pizzaService.getPizzaByDiameter(diameter));
    }

    /**
     * gets an object by ingredients
     * @param ingredients
     * @return object of the specified ingredients
     */
    @GetMapping("/pizzas/{ingredients}")
    public ResponseEntity<Pizza> getPizzaByIngredients(@PathVariable String ingredients) {
        return ResponseEntity.ok(pizzaService.getPizzaByIngredients(ingredients));
    }

    /**
     * gets an object by price
     * @param price
     * @return object of the specified price
     */
    @GetMapping("/pizzas/{price}")
    public ResponseEntity<List<Pizza>> getPizzaByPrice(@PathVariable Double price) {
        return ResponseEntity.ok(pizzaService.getPizzaByPrice(price));
    }

    /**
     * add new object
     * @param pizza
     * @return new object after saving it to the database
     */
    @PostMapping("/pizzas")
    public ResponseEntity<Pizza> addNewPizza(@RequestBody Pizza pizza) {
        return ResponseEntity.ok(pizzaService.savePizza(pizza));
    }

    /**
     * modifies an existing object
     * @param pizza
     * @return modified object after saving it
     */
    @PutMapping("/pizzas")
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza) {
        return ResponseEntity.ok(pizzaService.savePizza(pizza));
    }

    /**
     * deleting an object
     * @param id
     * @return a line informing about the deletion
     */
    @DeleteMapping("/pizzas/{id}")
    public ResponseEntity<String> deletePizzaById(@PathVariable int id) {
        pizzaService.deletePizzaById(id);
        return ResponseEntity.ok("Pizza with id = " + id + " was deleted");
    }
}