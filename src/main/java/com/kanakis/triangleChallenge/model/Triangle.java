package com.kanakis.triangleChallenge.model;

/**
 * Triangle is the base abstract class that represents a geometrical triangle shape, represented by the length of it's
 * 3 sides.
 *
 * @implNote Triangle is an abstract class with 3 concrete subclasses. The subclasses will be used in the static factory
 * {@link TriangleFactory} for instantiating a Triangle instance. The constructor is package private and accessible
 * only within this package, the only appropriate way to create a new instance is from {@link TriangleFactory}.
 * There are various advantages of static factory methods over constructor the main reason in this case is that they can
 * return an object of any subtype of their return type.
 */
public abstract class Triangle {

    /**
     * @implNote length of sides is integer and not double, float or BigDecimal. This has done to avoid edge cases of
     * 0.1 misrepresentation (for double & float) and the the performance hit from using BigDecimal.
     */
    private final int aSide, bSide, cSide;

    Triangle(int aSide, int bSide, int cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    /**
     * getType returns a TriangleType object that represents the triangles type.
     *
     * <p> Triangles can be classified according to the length of their sides in 3 categories:
     *  <ul>
     *      <li>Equilateral</li>
     *      <li>Isosceles</li>
     *      <li>Scalene</li>
     *  </ul>
     * </p>
     *
     * @return the type of triangle.
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
