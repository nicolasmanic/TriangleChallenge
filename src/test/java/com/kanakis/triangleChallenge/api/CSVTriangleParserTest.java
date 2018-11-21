package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.ErrorMsg;
import com.kanakis.triangleChallenge.core.model.Triangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CSVTriangleParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TriangleParser tp;

    @Before
    public void init() {
        tp = new CSVTriangleParser();
    }

    @Test
    public void shouldReturnCorrectTriangles() throws Exception {
        StringReader sr = new StringReader("1,1,1 \n5,5,3 \n3,4,5 ");
        List<Triangle> triangles = tp.parse(sr);
        assertEquals(triangles.size(), 3);
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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForNonNumericalInput() throws Exception {
        StringReader sr = new StringReader("a,b,c");
        tp.parse(sr);
    }
}
