package com.example.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MD5HashGeneratorTest {

    @Test
    public void testGenerateMD5Hash() {
        // Test with the given input format
        String input = "D62B4B428BC94D67B125C5E80A43654713 June 2024 01:103.30";
        String expectedHash = "6b8f3180533687cc6d6630b0354c411a";

        String actualHash = DataGeneratorUtils.generateMD5Hash(input);

        assertEquals(expectedHash, actualHash, "The generated MD5 hash does not match the expected value");
    }
}
