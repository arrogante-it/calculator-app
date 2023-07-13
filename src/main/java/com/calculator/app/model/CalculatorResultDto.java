package com.calculator.app.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorResultDto {
    private double result;

    private String error;
}