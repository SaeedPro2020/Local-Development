package com.example.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultRounder {
    public static BigDecimal roundResult(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
