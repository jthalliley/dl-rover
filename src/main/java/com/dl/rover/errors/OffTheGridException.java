package com.dl.rover.errors;

import com.dl.rover.domain.Point;

public class OffTheGridException extends Exception {

    public OffTheGridException(final Point atPoint) {

        System.out.println("*** OffTheGridException at " + atPoint);
    }

}
