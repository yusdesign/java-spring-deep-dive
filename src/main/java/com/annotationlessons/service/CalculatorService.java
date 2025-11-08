package com.annotationlessons.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя!");
        }
        return (double) a / b;
    }
    
    public String getServiceInfo() {
        return "Я CalculatorService с @Service аннотацией";
    }
}
