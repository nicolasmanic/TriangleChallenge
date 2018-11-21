package com.kanakis.triangleChallenge.api;

import com.kanakis.triangleChallenge.core.ErrorMsg;
import com.kanakis.triangleChallenge.core.model.Triangle;
import com.kanakis.triangleChallenge.core.model.TriangleFactory;

/**
 * @implNote AbstractTriangleParser is used as a "Skeletal" class in order to hide common methods used by the concrete
 * implementations of {@link TriangleParser} interface
 */
abstract class AbstractTriangleParser implements TriangleParser {

    Triangle constructTriangle(String[] line) {
        if (line.length != 3)
            throw new IllegalArgumentException(ErrorMsg.INVALID_NUM_OF_LENGTHS);

        int lengthA = Integer.parseInt(line[0].trim());
        int lengthB = Integer.parseInt(line[1].trim());
        int lengthC = Integer.parseInt(line[2].trim());

        return TriangleFactory.createTriangleByLength(lengthA, lengthB, lengthC);
    }
}
