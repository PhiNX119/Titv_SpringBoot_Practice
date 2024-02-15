package com.xuanphi.aop.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b) {
        //System.out.println(a + b);
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        //b = Double.parseDouble("khong");
        return a / b;
    }
}
