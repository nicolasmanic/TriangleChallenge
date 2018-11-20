package com.kanakis.triangleChallenge.core.validator;

/**
 * Validator interface is used for every kind of validation a shape may need.
 */
public interface Validator {
    /**
     * Validates that the provided lengths can create the concrete shape.
     *
     * @param lengths The length of each side of the shape.
     * @throws IllegalArgumentException in case validation fails.
     */
    void validate(int[] lengths);
}
