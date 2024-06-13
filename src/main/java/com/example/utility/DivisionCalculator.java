package com.example.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionCalculator {
    public static BigDecimal calculateDivision(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(num2) == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal divisor = num1.min(num2);
        BigDecimal dividend = num1.max(num2);
        return dividend.divide(divisor, 4, RoundingMode.HALF_UP);
    }
}
