                //******** FUNCTIONALITY *********/
/* 
    • Generates a Random UUID without dashes and uses uppercase letters.
    • Generates the current datetime in "02 January 2018 21:25" format.
    • Generates two Random decimal numbers between 1 and 100 with a scale of 4.
    • Divide the two generated decimal numbers, using the smallest of the two 
      as the divisor.
    • Rounds UP the answer of the division to an number with a scale of two.
    • Generates a String called "calculationResult" that is able to show what
      calculation was made and how the answer was rounded.
    • Generates an MD5 hash using (UUID + Current Datetime + Rounded answer ) as
      concatenated input.
    • Generate all the data above and creates a basic POJO class from the fields 
      above called "Container"
*/

package com.example.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class DataGeneratorUtils {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String generateCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    public static BigDecimal[] generateRandomDecimals() {
        BigDecimal num1 = BigDecimal.valueOf(Math.random() * 99 + 1).setScale(4, RoundingMode.HALF_UP);
        BigDecimal num2 = BigDecimal.valueOf(Math.random() * 99 + 1).setScale(4, RoundingMode.HALF_UP);
        return new BigDecimal[]{num1, num2};
    }

    public static BigDecimal calculateDivision(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(num2) == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal divisor = num1.min(num2);
        BigDecimal dividend = num1.max(num2);
        return dividend.divide(divisor, 4, RoundingMode.HALF_UP);
    }

    public static BigDecimal roundResult(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static String generateCalculationResult(BigDecimal num1, BigDecimal num2, BigDecimal roundedResult) {
        BigDecimal exactResult = num1.divide(num2, 4, RoundingMode.HALF_UP);
        return String.format("%s / %s = %s, rounded up to %s", num1, num2, exactResult, roundedResult);
    }

    public static String generateMD5Hash(String input) {
        try {
            // Obtain an instance of the MessageDigest class for MD5 hashing
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Convert the input string to a byte array and compute the hash
            byte[] hash = md.digest(input.getBytes());
            // Initialize a StringBuilder to construct the resulting hex string
            StringBuilder hexString = new StringBuilder();
            // Convert each byte in the hash array to a hex string
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                // Ensure each hex value is two characters long, pad with '0' if necessary
                if (hex.length() == 1) hexString.append('0');
                // Append the hex value to the StringBuilder
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static Container generateData() {
        String uuid = generateUUID();
        String formattedDateTime = generateCurrentDateTime();
        BigDecimal[] randomDecimals = generateRandomDecimals();
        BigDecimal num1 = randomDecimals[0];
        BigDecimal num2 = randomDecimals[1];
        BigDecimal divisionResult = calculateDivision(num1, num2);
        BigDecimal roundedResult = roundResult(divisionResult);
        String calculationResult = generateCalculationResult(num1, num2, roundedResult);
        String md5Hash = generateMD5Hash(uuid + formattedDateTime + roundedResult);

        System.out.println("string feed: " + uuid + formattedDateTime + roundedResult);

        return new Container(uuid, formattedDateTime, num1, num2, roundedResult, calculationResult, md5Hash);
    }
}
