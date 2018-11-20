package com.kanakis.triangleChallenge.core.validator;

import com.kanakis.triangleChallenge.core.ErrorMsg;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleValidatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Validator validator;

    @Before
    public void init() {
        validator = new TriangleValidator();
    }


    @Test
    public void shouldNotThrowException() {
        validator.validate(new int[]{2, 2, 2});
        validator.validate(new int[]{3, 5, 5});
        validator.validate(new int[]{3, 4, 5});
    }

    @Test
    //todo: add more test cases for 0 in different positions
    public void shouldThrowIllegalArgumentExceptionForNonPositiveLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        validator.validate(new int[]{0, 2, 2});
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForMoreThan3Lengths() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_NUM_OF_LENGTHS);
        validator.validate(new int[]{2, 2, 2, 2});
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForLessThan3Lengths() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_NUM_OF_LENGTHS);
        validator.validate(new int[]{2, 2});
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForViolationOfInequalityTheorem() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_TRIANGLE);
        validator.validate(new int[]{2, 10, 2});
    }
}
