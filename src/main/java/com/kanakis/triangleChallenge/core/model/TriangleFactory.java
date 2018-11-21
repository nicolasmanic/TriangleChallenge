package com.kanakis.triangleChallenge.core.model;

import com.kanakis.triangleChallenge.core.classifier.TriangleClassifier;
import com.kanakis.triangleChallenge.core.classifier.TriangleClassifierImpl;
import com.kanakis.triangleChallenge.core.validator.TriangleValidator;

/**
 * TriangleFactory is responsible for creating the different subclasses of {@link Triangle}.
 * It's the only way an external client can instantiate an {@link Triangle} object and handles all the logic for
 * validating and classifying a set of lengths in order to generate the correct triangle type.
 */
public class TriangleFactory {

    /**
     * @implNote TriangleClassifier takes an instance of {@link TriangleValidator} and is used as a validation
     * strategy before the classification.
     * @see TriangleValidator
     */
    private static final TriangleClassifier classifier = new TriangleClassifierImpl(new TriangleValidator());

    /**
     * createTriangleByLength method uses the {@link TriangleClassifier} to determine what type of {@link Triangle}
     * instance should be created based on the provided lengths.
     *
     * @param lengthA length of side A
     * @param lengthB length of side B
     * @param lengthC length of side C
     * @return triangle object
     * @throws IllegalArgumentException in case sides lengths validation fails.
     *
     * @implNote The classification logic could be integrated in the factory method but this would violate the
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
                //Since classifier uses TriangleValidator to validate the inputs, it should not be possible
                //to reach this code, a IllegalArgumentException should have been thrown prior.
                throw new RuntimeException("Triangle instantiation failed for unknown reasons");
        }
    }
}
