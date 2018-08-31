package com.dl.rover.domain;

import java.util.HashSet;
import java.util.Set;

import com.dl.rover.domain.FacingDirection;
import com.dl.rover.errors.*;

public class Grid {

    private static final int MIN_X =  0;
    private int maxX;

    private static final int MIN_Y =  0;
    private int maxY;

    private Set<Point> gridPoints; // Set used to avoid a large matrix of points.


    public Grid() {
        gridPoints = new HashSet<Point>();
    }

    public Grid(final int xWidth, final int yHeight) {
        this();
        maxX = xWidth;
        maxY = yHeight;
    }

    public void addObstacle(final Point atPoint) throws OffTheGridException {
        if (!isValidX(atPoint.getX()) || !isValidY(atPoint.getY())) {
            throw new OffTheGridException(atPoint);
        }

        gridPoints.add(atPoint); // Don't worry about duplicates
    }

    public boolean hasObstacle(final Point atPoint) {
        return gridPoints.contains(atPoint);
    }

    public void showObstacles() {
        for (final Point p : gridPoints) {
            System.out.println("Obstacle at " + p);
        }
    }

    public Point consideredPoint(final Point fromPoint,
				 final FacingDirection facingDirection,
				 final MovingDirection movingDirection) {

        Point result = fromPoint;

        switch(movingDirection) {
        case L:
        case R:
            break;

        case F:
            switch (facingDirection) {
            case N:
                result = new Point(fromPoint.getX(), wrapped(fromPoint.getY() - 1, MIN_Y, maxY));
                break;
            case S:
                result = new Point(fromPoint.getX(), wrapped(fromPoint.getY() + 1, MIN_Y, maxY));
                break;
            case E:
                result = new Point(wrapped(fromPoint.getX() + 1, MIN_X, maxX), fromPoint.getY());
                break;
            case W:
                result = new Point(wrapped(fromPoint.getX() - 1, MIN_X, maxX), fromPoint.getY());
                break;
            }
            break;

        case B:
            switch (facingDirection) {
            case N:
                result = new Point(fromPoint.getX(), wrapped(fromPoint.getY() + 1, MIN_Y, maxY));
                break;
            case S:
                result = new Point(fromPoint.getX(), wrapped(fromPoint.getY() - 1, MIN_Y, maxY));
                break;
            case E:
                result = new Point(wrapped(fromPoint.getX() - 1, MIN_X, maxX), fromPoint.getY());
                break;
            case W:
                result = new Point(wrapped(fromPoint.getX() + 1, MIN_X, maxX), fromPoint.getY());
                break;
            }
            break;
        }

        return result;
    }

    private boolean isValidX(final int x) {
        return (MIN_X <= x && x <= maxX);
    }

    private boolean isValidY(final int y) {
        return (MIN_Y <= y && y <= maxY);
    }

    private int wrapped(final int newDimension, final int minDimension, final int maxDimension) {
        return (newDimension < minDimension)
            ? maxDimension
            : (maxDimension < newDimension) ? minDimension : newDimension;
    }

}
