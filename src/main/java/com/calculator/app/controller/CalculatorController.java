package com.calculator.app.controller;

import com.calculator.app.model.CalculatorResultDto;
import com.calculator.app.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("${application.endpoint.calculator}")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/add")
    public CalculatorResultDto add(@RequestParam double number1,
                                   @RequestParam double number2) {
        double result = calculatorService.add(number1, number2);

        return CalculatorResultDto.builder()
                .result(result)
                .build();
    }

    @GetMapping("/subtract")
    public CalculatorResultDto subtract(@RequestParam double number1,
                                        @RequestParam double number2) {
        double result = calculatorService.subtract(number1, number2);

        return CalculatorResultDto.builder()
                .result(result)
                .build();
    }

    @GetMapping("/multiply")
    public CalculatorResultDto multiply(@RequestParam double number1,
                                        @RequestParam double number2) {
        double result = calculatorService.multiply(number1, number2);

        return CalculatorResultDto.builder()
                .result(result)
                .build();
    }

    @GetMapping("/divide")
    public CalculatorResultDto divide(@RequestParam double number1,
                                      @RequestParam double number2) {
        double result = calculatorService.divide(number1, number2);

        return CalculatorResultDto.builder()
                .result(result)
                .build();
    }
}
