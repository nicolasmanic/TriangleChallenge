package com.kanakis.triangleChallenge.model;

/**
 * Triangle is the base abstract class that represents a geometrical triangle shape, represented by the length of it's
 * 3 sides.
 * <p>
 * (TODO: update doc when factory method is created)
 *
 * @implNote Triangle is an abstract class with 3 concrete subclasses. The subclasses will be used in the static factory
 * for instantiating a Triangle instance. The constructor is package private and accessible only within this package,
 * the only appropriate way to create a new instance is from the static factor method provided. There are many advantages
 * in static factory methods over constructor the main reason in this case is that they can return an object of any
 * subtype of their return type.
 */
public abstract class Triangle {

    private final int aSide, bSide, cSide;

    Triangle(int aSide, int bSide, int cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    /**
     * getType returns a TriangleType object that represents the triangles type.
     * <p>
     * <p> Triangles can be classified according to the length of their sides in 3 categories:
     * <ul>
     * <li>Equilateral</li>
     * <li>Isosceles</li>
     * <li>Scalene</li>
     * </ul>
     * </p>
     *
     * @return the triangle type.
     * @see TriangleType
     */
    public abstract TriangleType getType();

    @Override
    public String toString() {
        return "Triangle{" +
                "Side A = " + aSide +
                ", Side B = " + bSide +
                ", Side C = " + cSide +
                ", Type = " + this.getType().getTypeName() +
                '}';
    }
}
