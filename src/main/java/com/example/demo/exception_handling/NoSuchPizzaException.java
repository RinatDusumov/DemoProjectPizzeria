package com.example.demo.exception_handling;

public class NoSuchPizzaException extends RuntimeException {
    public NoSuchPizzaException(String message) {
        super(message);
    }
}