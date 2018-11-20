package com.kanakis.triangleChallenge.core.validator;

/**
 * @implNote While interface have many advantages they cannot contain non public methods.
 * To solve the issue we use the "Skeletal" AbstractValidator for the {@link #validLengths(int[])} method
 * which will be useful for every future validation since 0 or negative lengths will never be an option in any shape.
 */
abstract class AbstractValidator implements Validator {

    /**
     * Checks the validity of a given length
     * <p>
     * Lengths should be >0
     *
     * @param lengths array of lengths
     * @return true if lengths are valid, false otherwise
     */
    boolean validLengths(int[] lengths) {
        for (int l : lengths) {
            if (l <= 0)
                return false;
        }
        return true;
    }
}
