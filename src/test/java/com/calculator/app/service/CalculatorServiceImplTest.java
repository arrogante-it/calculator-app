package com.calculator.app.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 8.0",
            "70456.0, 110000.0, 180456.0",
            "-2.0, 0.0, -2.0"
    })
    public void add(double number1, double number2, double expected) {
        double result = calculatorService.add(number1, number2);
        double delta = Math.ulp(result);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 2.0",
            "1000000.0, 999999.0, 1.0",
            "-2.0, 0.0, -2.0"
    })
    public void subtract(double number1, double number2, double expected) {
        double result = calculatorService.subtract(number1, number2);
        double delta = Math.ulp(result);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 15.0",
            "6.0, 10000000.0, 60000000.0",
            "-2.0, 0.0, 0.0"
    })
    public void multiply(double number1, double number2, double expected) {
        double result = calculatorService.multiply(number1, number2);
        double delta = Math.ulp(result);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 2.0, 2.5",
            "60000000.0, 10000000.0, 6.0",
            "-5.0, 2.0, -2.5"
    })
    public void divide(double number1, double number2, double expected) {
        double result = calculatorService.divide(number1, number2);
        double delta = Math.ulp(result);
        assertEquals(expected, result, delta);
    }

    @Test
    public void divideByZeroThrowsException() {
        double number1 = 100.0;
        double number2 = 0.0;

        String expectedErrorMessage = "cannot divide by zero";

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        calculatorService.divide(number1, number2));

        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}