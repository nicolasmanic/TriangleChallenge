package com.kanakis.triangleChallenge.model;

/**
 * A scalene triangle has all its sides of different lengths.
 */
public class Scalene extends Triangle {

    Scalene(int aSide, int bSide, int cSide) {
        super(aSide, bSide, cSide);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.SCALENE;
    }
}
