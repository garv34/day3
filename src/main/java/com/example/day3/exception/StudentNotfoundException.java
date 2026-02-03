package com.example.day3.exception;

public class StudentNotfoundException extends RuntimeException {
    public StudentNotfoundException(String message) {
        super(message);
    }
}
