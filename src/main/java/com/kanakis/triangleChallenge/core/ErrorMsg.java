package com.kanakis.triangleChallenge.core;

/**
 * Error messages.
 *
 * @implNote This class specifies the possible error messages that might occur when creating a new shape
 * based on the length of its sides. We use a final class with a private constructor, making it impossible to
 * instantiate or subclass the class. We could also use an ENUM instead of a final class by it would required more
 * boilerplate code.
 * Note that the code is not internationalised this can be easily fixed by using ResourceBundle class and moving
 * the messages in a properties files.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Triangle_inequality">https://en.wikipedia.org/wiki/Triangle_inequality</a>
 *
 */
public final class ErrorMsg {
    //General error messages
    public static final String INVALID_NUM_OF_LENGTHS = "Invalid number of lengths provided to create target shape.";

    //Triangle specific error messages
    public static final String NON_POSITIVE_LENGTH = "Length of at least one side is less than 1.";
    public static final String INVALID_TRIANGLE = "Sum of 2 sides is less than the third.";

    private ErrorMsg() {
    }
}
