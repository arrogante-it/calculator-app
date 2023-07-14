package com.calculator.app.controller;

import com.calculator.app.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {


    private MockMvc mockMvc;

    @Autowired
    CalculatorControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @MockBean
    private CalculatorService calculatorService;

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 9.0",
            "1000000.0, 1.0, 1000001.0",
            "2.5, -1.5, 3.0"
    })
    public void add(double number1, double number2, double expectedResult) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/calculator/add")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 2.0",
            "1000000.0, 1.0, 999999.0",
            "2.5, -1.5, 4.0"
    })
    public void subtract(double number1, double number2, double expectedResult) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/calculator/subtract")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "5.0, 3.0, 15.0",
            "100.0, 2.0, 200.0",
            "2.5, 1.5, 3.75"
    })
    public void multiply(double number1, double number2, double expectedResult) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/calculator/multiply")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "6.0, 3.0, 2.0",
            "10.0, 2.0, 5.0",
            "2.5, 0.0, 0.0"
    })
    public void divide(double number1, double number2, double expectedResult) throws Exception {
        if (number2 == 0.0) {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/calculator/divide")
                    .param("number1", String.valueOf(number1))
                    .param("number2", String.valueOf(number2)))
                    .andExpect(status().isBadRequest());
        } else {
            mockMvc.perform(MockMvcRequestBuilders.get("/divide")
                    .param("number1", String.valueOf(number1))
                    .param("number2", String.valueOf(number2)))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
        }
    }
}