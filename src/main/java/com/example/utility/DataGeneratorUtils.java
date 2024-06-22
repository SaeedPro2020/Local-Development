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
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
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
