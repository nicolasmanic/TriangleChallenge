package com.kanakis.triangleChallenge.core.model;

import com.kanakis.triangleChallenge.core.ErrorMsg;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class TriangleFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnEquilateral() {
        Triangle tr = TriangleFactory.createTriangleByLength(1, 1, 1);
        assertTrue(tr.getType() == TriangleType.EQUILATERAL);
    }

    @Test
    public void shouldReturnIsosceles() {
        Triangle tr = TriangleFactory.createTriangleByLength(5, 5, 3);
        assertTrue(tr.getType() == TriangleType.ISOSCELES);
    }

    @Test
    public void shouldReturnScalene() {
        Triangle tr = TriangleFactory.createTriangleByLength(3, 4, 5);
        assertTrue(tr.getType() == TriangleType.SCALENE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNonPositiveLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        TriangleFactory.createTriangleByLength(4, 0, 5);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        TriangleFactory.createTriangleByLength(5, 4, -3);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForViolationOfInequalityTheorem() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_TRIANGLE);
        TriangleFactory.createTriangleByLength(1, 1, 5);
    }
}
