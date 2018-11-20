package com.kanakis.triangleChallenge.model;

import com.kanakis.triangleChallenge.model.classifier.TriangleClassifier;
import com.kanakis.triangleChallenge.model.classifier.TriangleClassifierImpl;
import com.kanakis.triangleChallenge.model.validator.TriangleValidator;

/**
 * TriangleFactory is responsible for creating the different of subclasses of {@link Triangle}
 */
public class TriangleFactory {

    /**
     * @implNote TriangleClassifier takes an instance of {@link TriangleValidator}
     */
    private static final TriangleClassifier classifier = new TriangleClassifierImpl(new TriangleValidator());

    /**
     * createTriangleByLength method uses the {@link TriangleClassifier} to determine what type of {@link Triangle}
     * should be created based on the provided lengths.
     *
     * @param lengthA length of side A
     * @param lengthB length of side B
     * @param lengthC length of side C
     * @return Triangle
     * @throws IllegalArgumentException in case sides lengths validation fails.
     * @implNote The classification logic could be integrated in the factory method but this will violate the
     * single responsibility principle, visually clutter the method, and harm future extensibility.
     */
    public static Triangle createTriangleByLength(int lengthA, int lengthB, int lengthC) {

        switch (classifier.classify(lengthA, lengthB, lengthC)) {
            case EQUILATERAL:
                return new Equilateral(lengthA, lengthB, lengthC);
            case ISOSCELES:
                return new Isosceles(lengthA, lengthB, lengthC);
            case SCALENE:
                return new Scalene(lengthA, lengthB, lengthC);
            default:
                //Since classifier uses TriangleValidator to validate the inputs, so it should not be possible
                //to reach this code, because a IllegalArgumentException should have been thrown prior.
                throw new RuntimeException("Triangle instantiation failed for unknown reasons");
        }
    }
}
