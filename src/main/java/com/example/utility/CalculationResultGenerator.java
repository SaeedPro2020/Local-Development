package com.example.utility;

import java.math.BigDecimal;

public class CalculationResultGenerator {
    public static String generateCalculationResult(BigDecimal num1, BigDecimal num2, BigDecimal roundedResult) {
        @SuppressWarnings("deprecation")
        BigDecimal exactResult = num1.divide(num2, 4, BigDecimal.ROUND_HALF_UP);
        return String.format("%s / %s = %s, rounded up to %s", num1, num2, exactResult, roundedResult);
    }
}
    