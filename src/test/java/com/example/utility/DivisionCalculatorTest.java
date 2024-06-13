package com.example.utility;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionCalculatorTest {

    @Test
    public void testCalculateDivision() {
        // Test with num1 < num2
        BigDecimal num1 = new BigDecimal("3.4567");
        BigDecimal num2 = new BigDecimal("7.8912");

        BigDecimal expected = num2.divide(num1, 4, RoundingMode.HALF_UP); // Corrected expectation
        BigDecimal actual = DivisionCalculator.calculateDivision(num1, num2);

        assertEquals(expected, actual, "The division result does not match the expected value");

        // Test with num2 < num1
        num1 = new BigDecimal("8.1234");
        num2 = new BigDecimal("4.5678");

        expected = num1.divide(num2, 4, RoundingMode.HALF_UP); // Corrected expectation
        actual = DivisionCalculator.calculateDivision(num1, num2);

        assertEquals(expected, actual, "The division result does not match the expected value");

        // Test with equal numbers
        num1 = new BigDecimal("5.4321");
        num2 = new BigDecimal("5.4321");

        expected = BigDecimal.ONE; // Since num1 = num2, result should be 1
        actual = DivisionCalculator.calculateDivision(num1, num2);

        assertEquals(expected, actual, "The division result does not match the expected value");
    }
}
