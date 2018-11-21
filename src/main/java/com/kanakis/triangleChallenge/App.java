package com.kanakis.triangleChallenge;

import com.kanakis.triangleChallenge.api.CSVTriangleParser;
import com.kanakis.triangleChallenge.api.ConsoleTriangleParser;
import com.kanakis.triangleChallenge.api.TriangleParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * The entry point of the app. If no argument is passed then user is required to enter 3 integers using the console.
 * If a argument is passed the program assumes that is a valid path for a csv file and attempts to load the data
 * from the file. Both implementations print the resulted triangles at the console.
 */
public class App {

    public static void main(String[] args) {
        TriangleParser tp;
        InputStreamReader isr;
        try {
            if (args.length == 0) {
                tp = new ConsoleTriangleParser();
                isr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            } else {
                tp = new CSVTriangleParser();
                String filepath = args[0];
                FileInputStream fis = new FileInputStream(filepath);
                isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            }
            tp.parse(isr).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Parsing error: " + e.getMessage());
        }
    }
}
