package com.kanakis.triangleChallenge.core.validator;

import com.kanakis.triangleChallenge.core.ErrorMsg;

/**
 * TriangleValidator is responsible for validating triangle shapes.
 *
 * @implNote It extends {@link AbstractValidator} in order to have access to {@link AbstractValidator#validLengths(int[])}
 * and implements {@link Validator} interface.
 */
public class TriangleValidator extends AbstractValidator {

    /**
     * Validate if the integer array of lengths is valid for creating a triangle
     *
     * There are 3 cases it might fail:
     * <ul>
     * <li>lengths array does not contain 3 integers</li>
     * <li>lengths array contains at least one length less than 1</li>
     * <li>lengths fail Inequality Theorem check</li>
     * </ul>
     *
     * @param lengths The length of each side of the shape.
     * @throws IllegalArgumentException in case validation fails.
     *
     */
    @Override
    public void validate(int[] lengths) {
        if (lengths.length != 3)
            throw new IllegalArgumentException(ErrorMsg.INVALID_NUM_OF_LENGTHS);

        if (!validLengths(lengths))
            throw new IllegalArgumentException(ErrorMsg.NON_POSITIVE_LENGTH);

        if (!triangleInequalityCheck(lengths))
            throw new IllegalArgumentException(ErrorMsg.INVALID_TRIANGLE);
    }

    private boolean triangleInequalityCheck(int[] lengths) {
        int a = lengths[0];
        int b = lengths[1];
        int c = lengths[2];

        return (a + b > c && a + c > b && b + c > a);
    }
}
