package com.kanakis.triangleChallenge.model.factory;

import com.kanakis.triangleChallenge.model.ErrorMsg;
import com.kanakis.triangleChallenge.model.Triangle;
import com.kanakis.triangleChallenge.model.TriangleType;
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
        Triangle tr = TriangleFactory.createTriangleByLength(2, 2, 4);
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
        TriangleFactory.createTriangleByLength(0, 4, 5);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNegativeLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        TriangleFactory.createTriangleByLength(-1, 4, 5);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForViolationOfInequalityTheorem() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_TRIANGLE);
        TriangleFactory.createTriangleByLength(1, 1, 5);
    }
}
