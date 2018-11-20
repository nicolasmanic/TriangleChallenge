package com.kanakis.triangleChallenge.model.classifier;

import com.kanakis.triangleChallenge.model.TriangleType;
import com.kanakis.triangleChallenge.model.validator.Validator;

public class TriangleClassifierImpl implements TriangleClassifier {
    private Validator triangleValidator;

    /**
     * @implNote TriangleClassifierImpl constructor takes a {@link Validator} instance as argument.
     * Using dependency injection TriangleClassifierImpl is not tightly coupled with the validation rules, so any future
     * changes in the validation process will not change the classification implementation.
     */
    public TriangleClassifierImpl(Validator triangleValidator) {
        this.triangleValidator = triangleValidator;
    }

    /**
     * classify first check if passed parameters are valid to create a triangle and then
     * based on <a href="https://en.wikipedia.org/wiki/Triangle#By_lengths_of_sides">https://en.wikipedia.org/wiki/Triangle</a>
     * returns the type of triangle.
     */
    @Override
    public TriangleType classify(int sideA, int sideB, int sideC) {
        triangleValidator.validate(new int[]{sideA, sideB, sideC});

        if (sideA == sideB && sideB == sideC)
            return TriangleType.EQUILATERAL;
        else if (sideA == sideB || sideB == sideC || sideA == sideC)
            return TriangleType.ISOSCELES;
        else
            return TriangleType.SCALENE;
    }
}
