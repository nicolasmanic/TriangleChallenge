package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.model.Triangle;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVTriangleParser extends AbstractTriangleParser {

    @Override
    public List<Triangle> parse(Reader in) throws IOException {
        try (CSVReader reader = new CSVReader(in)) {
            String[] line;
            List<Triangle> triangles = new ArrayList<>();
            while ((line = reader.readNext()) != null) {
                triangles.add(constructTriangle(line));
            }
            return triangles;
        }
    }
}
