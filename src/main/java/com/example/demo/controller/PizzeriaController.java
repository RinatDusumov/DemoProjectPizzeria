package com.example.demo.controller;

import com.example.demo.entity.Pizzeria;
import com.example.demo.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzeriaController {
    @Autowired
    private PizzeriaService pizzeriaService;

    /**
     * gets all objects
     * @return all objects
     */
    @GetMapping("/pizzerias")
    public ResponseEntity<List<Pizzeria>> getAllPizzerias() {
        return ResponseEntity.ok(pizzeriaService.getAllPizzerias());
    }

    /**
     * gets an object by id
     * @param id
     * @return object of the specified id
     */
    @GetMapping("/pizzerias/{id}")
    public ResponseEntity<Pizzeria> getPizzeriaById(@PathVariable int id) {
        return ResponseEntity.ok(pizzeriaService.getPizzeriaById(id));
    }


    /**
     * gets an object by name
     * @param name
     * @return object of the specified name
     */
    @GetMapping("/pizzerias/{name}")
    public ResponseEntity<Pizzeria> getPizzeriaByName(@PathVariable String name) {
        return ResponseEntity.ok(pizzeriaService.getPizzeriaByName(name));
    }

    /**
     * ets an object by address
     * @param address
     * @return object of the specified address
     */
    @GetMapping("/pizzerias/{address}")
    public ResponseEntity<Pizzeria> getPizzeriaByAddress(@PathVariable String address) {
        return ResponseEntity.ok(pizzeriaService.getPizzeriaByAddress(address));
    }

    /**
     * gets an object by phoneNumber
     * @param phoneNumber
     * @return object of the specified phoneNumber
     */
    @GetMapping("/pizzerias/{phoneNumber}")
    public ResponseEntity<Pizzeria> getPizzeriaByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(pizzeriaService.getPizzeriaByPhoneNumber(phoneNumber));
    }

    /**
     * add new object
     * @param pizzeria
     * @return new object after saving it to the database
     */
    @PostMapping("/pizzerias")
    public ResponseEntity<Pizzeria> addNewPizzeria(@RequestBody Pizzeria pizzeria) {
        return ResponseEntity.ok(pizzeriaService.savePizzeria(pizzeria));
    }

    /**
     * modifies an existing object
     * @param pizzeria
     * @return modified object after saving it
     */
    @PutMapping("/pizzerias")
    public ResponseEntity<Pizzeria> updatePizzeria(@RequestBody Pizzeria pizzeria) {
        return ResponseEntity.ok(pizzeriaService.savePizzeria(pizzeria));
    }

    /**
     * deleting an object
     * @param id
     * @return a line informing about the deletion
     */
    @DeleteMapping("/pizzerias/{id}")
    public ResponseEntity<String> deletePizzeriaById(@PathVariable int id) {
        pizzeriaService.deletePizzeriaById(id);
        return ResponseEntity.ok("Pizzeria with id = " + id + " was deleted");
    }
}