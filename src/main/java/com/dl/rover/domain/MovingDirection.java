package com.dl.rover.domain;

import com.dl.rover.errors.*;

public enum MovingDirection {

    F("Forward"),
    B("Backward"),
    L("Left"),
    R("Right");

    private String printable;

    private MovingDirection(final String printable) {
        this.printable = printable;
    }

    public String display() {
        return printable;
    }

    public static MovingDirection valueOf(final char c) throws InvalidCommandException {
        try {
            return MovingDirection.valueOf(String.valueOf(c).toUpperCase());
        } catch (final Exception e) {
            throw new InvalidCommandException(c);
        }
    }

}
