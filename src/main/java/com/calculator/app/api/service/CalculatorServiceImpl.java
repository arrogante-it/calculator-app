package com.calculator.app.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("cannot divide by zero");
        }
        return number1 / number2;
    }
}
