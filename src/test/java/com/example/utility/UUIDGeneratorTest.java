package com.example.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UUIDGeneratorTest {

    @Test
    public void testGenerateUUID() {
        String uuid = DataGeneratorUtils.generateUUID();
        
        // Check that the UUID is not null
        assertNotNull(uuid);
        
        // Check that the UUID does not contain dashes
        assertFalse(uuid.contains("-"));
        
        // Check that the UUID is uppercase
        assertTrue(uuid.equals(uuid.toUpperCase()));
    }
}
