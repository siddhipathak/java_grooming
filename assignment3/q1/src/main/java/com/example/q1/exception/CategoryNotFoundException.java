package com.example.q1.exception;

public class CategoryNotFoundException extends RuntimeException {
    
    public CategoryNotFoundException(String messase){
        super(messase);
    }
}
