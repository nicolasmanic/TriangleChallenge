package com.kanakis.triangleChallenge.model.validator;

import com.kanakis.triangleChallenge.model.ErrorMsg;

/**
 * TriangleValidator is responsible for validating triangle shapes.
 *
 * @implNote It extends {@link AbstractValidator} in order to have access to {@link AbstractValidator#validLengths(int[])} and
 */
public class TriangleValidator extends AbstractValidator {

    /**
     * validate if the integer array of lengths is valid for creating a triangle
     * <p>
     * There are 3 cases it might fail
     * <ul>
     * <li>lengths array does not hold 3 integers</li>
     * <li>lengths arrays contains at least one length less tha 1 </li>
     * <li>lengths arrays fail Inequality Theorem Check</li>
     * </ul>
     *
     * @param lengths The length of each side of the shape.
     * @throws IllegalArgumentException in case validation fails.
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
