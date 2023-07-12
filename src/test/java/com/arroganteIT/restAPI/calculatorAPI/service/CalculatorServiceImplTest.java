package com.arroganteIT.restAPI.calculatorAPI.service;

import com.calculator.app.api.service.CalculatorService;
import com.calculator.app.api.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorServiceImplTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 8.0",
            "2.0, 3.0, 5.0",
            "-2.0, 2.0, 0.0"
    })
    public void add(double number1, double number2, double expected) {
        double result = calculatorService.add(number1, number2);
        double delta = Math.ulp(result);
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 2.0",
            "2.0, 3.0, -1.0",
            "-2.0, 2.0, -4.0"
    })
    public void subtract(double number1, double number2, double expected) {
        double result = calculatorService.subtract(number1, number2);
        double delta = Math.ulp(result);
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 15.0",
            "2.0, 3.0, 6.0",
            "-2.0, 2.0, -4.0"
    })
    public void multiply(double number1, double number2, double expected) {
        double result = calculatorService.multiply(number1, number2);
        double delta = Math.ulp(result);
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 2.0, 2.5",
            "10.0, 4.0, 2.5",
            "-5.0, 2.0, -2.5"
    })
    public void divide(double number1, double number2, double expected) {
        double result = calculatorService.divide(number1, number2);
        double delta = Math.ulp(result);
        Assertions.assertEquals(expected, result, delta);
    }
}