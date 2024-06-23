         //******** FUNCTIONALITY *********/
/* 
    This class is responsible for writing the contents of a 
    Container object to a JSON file.
*/

package com.example.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonFileWriter {
    public static void writeToJsonFile(Container container, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), container);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}