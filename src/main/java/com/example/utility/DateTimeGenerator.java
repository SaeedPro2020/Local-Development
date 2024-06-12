package com.example.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeGenerator {
    public static String generateCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        return LocalDateTime.now().format(formatter);
    }
}
