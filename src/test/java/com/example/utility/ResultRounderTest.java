package com.example.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

public class ResultRounderTest {

    @Test
    public void testRoundResult() {
        // Test with a random decimal number
        BigDecimal number = new BigDecimal("123.4567");
        BigDecimal expected = new BigDecimal("123.46");
        BigDecimal actual = DataGeneratorUtils.roundResult(number);
        
        assertEquals(expected, actual, "The number should be rounded to 2 decimal places");

        // Test with another random decimal number
        number = new BigDecimal("987.6543");
        expected = new BigDecimal("987.65");
        actual = DataGeneratorUtils.roundResult(number);
        
        assertEquals(expected, actual, "The number should be rounded to 2 decimal places");

        // Test with rounding down
        number = new BigDecimal("0.1234");
        expected = new BigDecimal("0.12");
        actual = DataGeneratorUtils.roundResult(number);
        
        assertEquals(expected, actual, "The number should be rounded to 2 decimal places");

        // Test with rounding up
        number = new BigDecimal("0.1299");
        expected = new BigDecimal("0.13");
        actual = DataGeneratorUtils.roundResult(number);
        
        assertEquals(expected, actual, "The number should be rounded to 2 decimal places");
    }
}
