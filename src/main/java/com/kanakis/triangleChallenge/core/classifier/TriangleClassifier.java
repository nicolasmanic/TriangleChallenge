package com.kanakis.triangleChallenge.core.classifier;

import com.kanakis.triangleChallenge.core.model.Triangle;
import com.kanakis.triangleChallenge.core.model.TriangleType;

/**
 * TriangleClassifier classifies {@link Triangle} based on different criteria.
 * Currently only length-based classification is implemented.
 */
public interface TriangleClassifier {
    /**
     * Classifies the triangle based on the lengths of its 3 sides.
     *
     * <ul>
     * <li><b>Equilateral:</b> all sides have the same length.</li>
     * <li><b>Isosceles:</b> only two sides have the same length.</li>
     * <li><b>Scalene:</b> all sides have different lengths.</li>
     * </ul>
     *
     * @param sideA length of side A
     * @param sideB length of side B
     * @param sideC length of side C
     * @return type of triangle.
     * @throws IllegalArgumentException in case sides lengths validation fails.
     * @see TriangleType
     */
    TriangleType classify(int sideA, int sideB, int sideC);
}
