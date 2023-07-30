package com.example.demo.exception_handling;

public class NoSuchPizzeriaException extends RuntimeException {
    public NoSuchPizzeriaException(String message) {
        super(message);
    }
}