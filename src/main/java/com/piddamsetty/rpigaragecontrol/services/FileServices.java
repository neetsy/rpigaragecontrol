package com.piddamsetty.rpigaragecontrol.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by praneet on 8/11/18.
 */
public class FileServices {
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public String resourceFileRead(String path) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(path);
            return readFromInputStream(inputStream);
        } catch (Exception e) {
            System.out.println("Error while reading from file: " + path + " Exception:  " + e.getMessage());
        }
        return "Something Went Wrong";
    }
}
