package com.calculator.app.controller;

import com.calculator.app.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    private static final String API_PATH = "/api/v1/calculator";

    @Test
    public void add() throws Exception {
        double number1 = 2.5;
        double number2 = 3.7;
        double expectedResult = 6.2;

        Mockito.when(calculatorService.add(number1, number2)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/add")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @Test
    public void subtract() throws Exception {
        double number1 = 4.4;
        double number2 = 2.2;
        double expectedResult = 2.2;

        Mockito.when(calculatorService.subtract(number1, number2)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/subtract")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @Test
    public void multiply() throws Exception {
        double number1 = 2.5;
        double number2 = 2.0;
        double expectedResult = 5.0;

        Mockito.when(calculatorService.multiply(number1, number2)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/multiply")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }

    @Test
    public void divide() throws Exception {
        double number1 = 5.0;
        double number2 = 2.0;
        double expectedResult = 2.5;

        Mockito.when(calculatorService.divide(number1, number2)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get(API_PATH + "/divide")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));
    }
}