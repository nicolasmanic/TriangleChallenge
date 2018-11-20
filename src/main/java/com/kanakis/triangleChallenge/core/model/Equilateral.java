package com.kanakis.triangleChallenge.core.model;

/**
 * An equilateral triangle has all sides the same length.
 */
public class Equilateral extends Triangle {

    Equilateral(int aSide, int bSide, int cSide) {
        super(aSide, bSide, cSide);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.EQUILATERAL;
    }
}
