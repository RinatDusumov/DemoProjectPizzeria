package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "pizzas")
@Data
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "diameter")
    private Integer diameter;

    @NotBlank
    @Column(name = "ingredients")
    private String ingredients;

    @NotBlank
    @Column(name = "price")
    private Double price;

    @Column(name = "is_remote")
    private Boolean isRemote;

    @Column(name = "create_at")
    private Timestamp createAt;

    public Pizza(String name, Integer diameter, String ingredients,
                 Double price) {
        this.name = name;
        this.diameter = diameter;
        this.ingredients = ingredients;
        this.price = price;
    }
}