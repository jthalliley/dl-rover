package com.dl.rover.domain;


public enum FacingDirection {

    N("North"),
    S("South"),
    E("East"),
    W("West");

    private String printable;

    private FacingDirection(final String printable) {
        this.printable = printable;
    }

    public String display() {
        return printable;
    }

    public FacingDirection turn(final MovingDirection movingDirection) {

        switch (movingDirection) {
        case F:
        case B:
            break;

        case L:
            switch (this) {
            case N: return W;
            case S: return E;
            case E: return N;
            case W: return S;
            }

        case R:
            switch (this) {
            case N: return E;
            case S: return W;
            case E: return S;
            case W: return N;
            }
        }

        return this;
    }

}
