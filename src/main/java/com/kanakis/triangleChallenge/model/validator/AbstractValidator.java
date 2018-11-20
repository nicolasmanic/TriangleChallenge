package com.kanakis.triangleChallenge.model.validator;

/**
 * @implNote While interface have many advantages they cannot contain non public methods.
 * To solve the issue we the "Skeletal" AbstractValidator for the validLengths method which will be useful for
 * every future validation since 0 or negative lengths will never be available in any shape.
 */
abstract class AbstractValidator implements Validator {

    boolean validLengths(int[] lengths) {
        for (int l : lengths) {
            if (l <= 0)
                return false;
        }
        return true;
    }
}
