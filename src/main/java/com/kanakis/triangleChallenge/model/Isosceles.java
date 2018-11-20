package com.kanakis.triangleChallenge.model;

/**
 * An isosceles triangle has two sides of equal length.
 */
public class Isosceles extends Triangle {

    Isosceles(int aSide, int bSide, int cSide) {
        super(aSide, bSide, cSide);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.ISOSCELES;
    }
}
