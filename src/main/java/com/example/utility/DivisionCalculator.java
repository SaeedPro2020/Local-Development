package com.example.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionCalculator {
    public static BigDecimal calculateDivision(BigDecimal num1, BigDecimal num2) {
        return num1.divide(num2, 4, RoundingMode.HALF_UP);
    }
}
