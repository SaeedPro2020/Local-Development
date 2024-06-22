    //******** FUNCTIONALITY *********/
/* 
    Plain Old Java Object for generated data
*/

package com.example.utility;

import java.math.BigDecimal;

public class Container {
    private String uuid;
    private String dateTime;
    private BigDecimal num1;
    private BigDecimal num2;
    private BigDecimal roundedResult;
    private String calculationResult;
    private String md5Hash;

    public Container(String uuid, String dateTime, BigDecimal num1, BigDecimal num2, BigDecimal roundedResult, String calculationResult, String md5Hash) {
        this.uuid = uuid;
        this.dateTime = dateTime;
        this.num1 = num1;
        this.num2 = num2;
        this.roundedResult = roundedResult;
        this.calculationResult = calculationResult;
        this.md5Hash = md5Hash;
    }

    // Getters for all fields (required for Jackson serialization)
    public String getUuid() { return uuid; }
    public String getDateTime() { return dateTime; }
    public BigDecimal getNum1() { return num1; }
    public BigDecimal getNum2() { return num2; }
    public BigDecimal getRoundedResult() { return roundedResult; }
    public String getCalculationResult() { return calculationResult; }
    public String getMd5Hash() { return md5Hash; }

    @Override
    public String toString() {
        return "Container{" +
                "uuid='" + uuid + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", roundedResult=" + roundedResult +
                ", calculationResult='" + calculationResult + '\'' +
                ", md5Hash='" + md5Hash + '\'' +
                '}';
    }
}
