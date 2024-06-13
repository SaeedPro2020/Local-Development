package com.example.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

public class CalculationResultGeneratorTest {

    @Test
    public void testGenerateCalculationResult() {
        // Test with valid BigDecimal values
        final BigDecimal num1 = new BigDecimal("10");
        final BigDecimal num2 = new BigDecimal("3");
        final BigDecimal roundedResult = new BigDecimal("3.33");

        String expectedResult = "10 / 3 = 3.3333, rounded up to 3.33";
        String actualResult = CalculationResultGenerator.generateCalculationResult(num1, num2, roundedResult);

        assertEquals(expectedResult, actualResult, "The result string is not as expected");

        // Test with integer values
        final BigDecimal num1Int = new BigDecimal("15");
        final BigDecimal num2Int = new BigDecimal("4");
        final BigDecimal roundedResultInt = new BigDecimal("3.75");

        expectedResult = "15 / 4 = 3.7500, rounded up to 3.75";
        actualResult = CalculationResultGenerator.generateCalculationResult(num1Int, num2Int, roundedResultInt);

        assertEquals(expectedResult, actualResult, "The result string is not as expected with integer inputs");

        // Test with divisor as zero
        // final BigDecimal num1DivByZero = new BigDecimal("10");
        // final BigDecimal num2DivByZero = BigDecimal.ZERO;

        // Exception exception = assertThrows(ArithmeticException.class, () -> {
        //     CalculationResultGenerator.generateCalculationResult(num1DivByZero, num2DivByZero, roundedResult);
        // });

        // String expectedMessage = "Division by zero";
        // String actualMessage = exception.getMessage();
        // assertTrue(actualMessage.contains(expectedMessage), "Expected ArithmeticException for division by zero");
    }
}
