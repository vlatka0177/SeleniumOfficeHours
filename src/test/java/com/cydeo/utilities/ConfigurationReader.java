package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // 1. Create an object of Properties
    private static Properties properties = new Properties(); // static runs before anything else

    static{

        try { // Surround with try/catch to handle exceptions

            // 2. Open the file in Java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties"); // FileNotFoundException e

            // 3. Load the properties' object using FileInputStream object
            properties.load(file); // IOException e

            // 4. Close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }
}
