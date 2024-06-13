package com.example.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class DateTimeGeneratorTest {

    @Test
    public void testGenerateCurrentDateTime() {
        String dateTime = DateTimeGenerator.generateCurrentDateTime();
        
        // Check that the datetime string is in the correct format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        boolean isValid = true;
        try {
            LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            isValid = false;
        }

        assertTrue(isValid, "The generated datetime does not match the expected format");
        
        // Additionally, verify the pattern using regex
        String regex = "\\d{2} [A-Z][a-z]+ \\d{4} \\d{2}:\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        assertTrue(pattern.matcher(dateTime).matches(), "The generated datetime does not match the regex pattern");
    }
}
