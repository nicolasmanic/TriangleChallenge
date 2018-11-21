package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.model.Triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleTriangleParser extends AbstractTriangleParser {

    @Override
    public List<Triangle> parse(Reader in) throws IOException {
        System.out.print("Enter 3 integers lengths for each side, separated by comma ',': " + System.lineSeparator());
        BufferedReader br = new BufferedReader(in);

        String[] line = br.readLine().split(",");
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(constructTriangle(line));
        return triangles;
    }
}
