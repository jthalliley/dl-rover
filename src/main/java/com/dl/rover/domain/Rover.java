package com.dl.rover.domain;

import com.dl.rover.errors.*;

public class Rover {

    private Point           currentLocation;
    private FacingDirection facingDirection;

    public Rover(final Point initialLocation, final FacingDirection initialFacingDirection) {
        setLocation(initialLocation);
        setFacingDirection(initialFacingDirection);
    }

    public Point getLocation() {
        return currentLocation;
    }

    private void setLocation(final Point location) {
        currentLocation = location;
    }

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    private void setFacingDirection(final FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void move(final Grid grid, final MovingDirection movingDirection) {

        Point newPoint = grid.consideredPoint(getLocation(), facingDirection, movingDirection);

        if (grid.hasObstacle(newPoint)) {
            System.out.println("!!! Cannot move " + movingDirection.display() + " from " + getLocation() + " due to obstacle.");
            return;
        }

        setLocation(newPoint);
    }

    public void turn(final MovingDirection movingDirection) {

        setFacingDirection(facingDirection.turn(movingDirection));
    }

    public void executeCommands(final char[] commands, final Grid grid)
        throws InvalidCommandException, OffTheGridException {

        for (char command : commands) {
            MovingDirection movingDirection = MovingDirection.valueOf(command);

            System.out.println("Attempting to move " + movingDirection.display() + " from " + getLocation() + " while facing " + getFacingDirection().display());

            switch (movingDirection) {
            case F:
            case B:
                move(grid, movingDirection);
                break;
            case L:
            case R:
                turn(movingDirection);
                break;
            }

            System.out.println("Now at " + getLocation() + " facing " + getFacingDirection().display());
        }

    }

}

