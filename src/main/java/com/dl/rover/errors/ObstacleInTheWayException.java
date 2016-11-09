package com.dl.rover.errors;

import com.dl.rover.domain.Point;

public class ObstacleInTheWayException extends Exception {

    public ObstacleInTheWayException(final Point atPoint) {

        System.out.println("*** ObstacleInTheWayException at " + atPoint);
    }

}
