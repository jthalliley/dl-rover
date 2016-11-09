package com.dl.rover.domain;


public class Point {

    private int x, y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int hashCode() {
        int hash = x + (y * 1000);
        return hash;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Point)) return false;

        Point other = (Point)o;

        return (this.getX() == other.getX()) && (this.getY() == other.getY());
    }

}
