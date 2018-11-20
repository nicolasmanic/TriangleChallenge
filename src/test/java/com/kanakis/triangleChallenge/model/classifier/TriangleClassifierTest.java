package com.kanakis.triangleChallenge.model.classifier;

import com.kanakis.triangleChallenge.model.ErrorMsg;
import com.kanakis.triangleChallenge.model.TriangleType;
import com.kanakis.triangleChallenge.model.validator.Validator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class TriangleClassifierTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Mock
    private Validator validator;
    private TriangleClassifier classifier;

    @Before
    public void init() {
        classifier = new TriangleClassifierImpl(validator);
    }

    @Test
    public void shouldReturnEquilateral() {
        assertTrue(classifier.classify(1, 1, 1) == TriangleType.EQUILATERAL);
    }

    @Test
    public void shouldReturnIsosceles() {
        assertTrue(classifier.classify(5, 5, 3) == TriangleType.ISOSCELES);
    }

    @Test
    public void shouldReturnScalene() {
        assertTrue(classifier.classify(3, 4, 5) == TriangleType.SCALENE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNonPositiveLength() {
        doThrow(new IllegalArgumentException(ErrorMsg.NON_POSITIVE_LENGTH)).when(validator).validate(any(int[].class));
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        classifier.classify(0, 4, 5);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForViolationOfInequalityTheorem() {
        doThrow(new IllegalArgumentException(ErrorMsg.INVALID_TRIANGLE)).when(validator).validate(any(int[].class));
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_TRIANGLE);
        classifier.classify(1, 1, 5);
    }
}
