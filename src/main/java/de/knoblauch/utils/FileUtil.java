package de.knoblauch.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileUtil {

    public static List<String> readLines(String fileName) {
        var resourcePath = "inputs/" + fileName;

        try (InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Resource not found: " + resourcePath);
            }
            return new BufferedReader(new InputStreamReader(is)).lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource: " + resourcePath, e);
        }
    }
}
