package com.kanakis.triangleChallenge.core.model;

/**
 * TriangleType defines the 3 types a geometrical triangle can have.
 * <ul>
 * <li><b>Equilateral:</b> all sides have the same length.</li>
 * <li><b>Isosceles:</b> only two sides have the same length.</li>
 * <li><b>Scalene:</b> all sides have different lengths.</li>
 * </ul>
 *
 */
public enum TriangleType {
    EQUILATERAL("Equilateral"),
    ISOSCELES("Isosceles"),
    SCALENE("Scalene");

    private final String type;

    TriangleType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return type;
    }
}
