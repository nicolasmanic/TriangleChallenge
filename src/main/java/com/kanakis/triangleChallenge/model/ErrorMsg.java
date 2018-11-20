package com.kanakis.triangleChallenge.model;

/**
 * Error messages.
 *
 * @implNote This class specifies the possible error messages that might occur when creating a new shape
 * based on the length of its sides . We use a final class with a private constructor,  making it impossible to
 * instantiate or subclass the class. We can also use an ENUM.
 * @see <a href="https://en.wikipedia.org/wiki/Triangle_inequality">https://en.wikipedia.org/wiki/Triangle_inequality</a>
 * <p>
 * TODO: this isn't internationalised do I need it to be?
 */
public final class ErrorMsg {
    //General error messages
    public static final String INVALID_NUM_OF_LENGTHS = "Invalid number of lengths provided to create target shape";

    //Triangle specific error messages
    public static final String NON_POSITIVE_LENGTH = "Length of at least one side is less than 1";
    public static final String INVALID_TRIANGLE = "Sum of 2 sides is less than the third";

    private ErrorMsg() {
    }
}
