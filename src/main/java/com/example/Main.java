package com.example;

import com.example.utility.*;

public class Main {
    public static void main(String[] args) {

            // Generate data using the utility method
            Container container = DataGeneratorUtils.generateData();
        JsonFileWriter.writeToJsonFile(container, "output.json");

        System.out.println(container);
    }
}
