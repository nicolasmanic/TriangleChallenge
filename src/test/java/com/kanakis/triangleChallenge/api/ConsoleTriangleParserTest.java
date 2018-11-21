package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.ErrorMsg;
import com.kanakis.triangleChallenge.core.model.Triangle;
import com.kanakis.triangleChallenge.core.model.TriangleType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ConsoleTriangleParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TriangleParser tp;

    @Before
    public void init() {
        tp = new ConsoleTriangleParser();
    }

    @Test
    public void shouldReturnCorrectTriangles() throws Exception {
        StringReader sr = new StringReader("1,1,1");
        List<Triangle> triangles = tp.parse(sr);
        assertEquals(triangles.get(0).getType(), TriangleType.EQUILATERAL);

        sr = new StringReader("5,5,3");
        triangles = tp.parse(sr);
        assertEquals(triangles.get(0).getType(), TriangleType.ISOSCELES);

        sr = new StringReader("3,4,5");
        triangles = tp.parse(sr);
        assertEquals(triangles.get(0).getType(), TriangleType.SCALENE);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForMoreThan3Lengths() throws Exception {
        StringReader sr = new StringReader("1,1,1,1");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_NUM_OF_LENGTHS);
        tp.parse(sr);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForLessThan3Lengths() throws Exception {
        StringReader sr = new StringReader("1,1");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_NUM_OF_LENGTHS);
        tp.parse(sr);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForViolationOfInequalityTheorem() throws Exception {
        StringReader sr = new StringReader("1,2,1");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.INVALID_TRIANGLE);
        tp.parse(sr);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNonPositiveLength() throws Exception {
        StringReader sr = new StringReader("1,-2,1");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(ErrorMsg.NON_POSITIVE_LENGTH);
        tp.parse(sr);
    }
}
