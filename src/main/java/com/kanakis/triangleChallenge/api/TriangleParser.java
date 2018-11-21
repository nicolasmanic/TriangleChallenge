package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.model.Triangle;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * TriangleParser defines the API for the various way the application can parse external data and return
 * one or more {@link Triangle} objects.
 */
public interface TriangleParser {
    /**
     * Takes a Reader instance as argument and returns a list of {@link Triangle}
     *
     * @param in Reader instance
     * @return List of {@link Triangle}
     * @throws IOException              propagates Reader IOException when I/O error occurs
     * @throws IllegalArgumentException for invalid lengths
     * @implNote The input of parser is a Reader object, this increases the flexibility of the API, as the end user
     * can pass any type of Reader instance, it also makes the code more testable.
     */
    List<Triangle> parse(Reader in) throws IOException;
}
