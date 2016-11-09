package com.dl.rover;

import com.dl.rover.domain.*;

public class Main {

    public static void main(final String[] args) {

        try {
            System.out.println("------------ Test 1 ---------------------");

            Grid grid = new Grid(10, 10);

            grid.addObstacle(new Point(3,3));
            grid.addObstacle(new Point(3,4));
            grid.addObstacle(new Point(3,5));
            grid.addObstacle(new Point(3,6));
            grid.addObstacle(new Point(3,7));

            //DEBUG            grid.showObstacles();

            Rover rover = new Rover(new Point(0,0), FacingDirection.E);

            char[] commands = new char[] {
                'f', 'f', 'f', // now at (3,0)
                'r',
                'f', 'f', // now at (3,2)
                'f',      // OBSTACLE!
                'r',
                'b', 'b' // just fine
            };

            rover.executeCommands(commands, grid);

        } catch (final Exception e) {
        }

        try {
            System.out.println("------------ Test 2 ---------------------");

            Grid grid = new Grid(10, 10);

            grid.addObstacle(new Point(3,3));
            grid.addObstacle(new Point(3,4));
            grid.addObstacle(new Point(3,5));
            grid.addObstacle(new Point(3,6));
            grid.addObstacle(new Point(3,7));

            //DEBUG            grid.showObstacles();

            Rover rover = new Rover(new Point(0,0), FacingDirection.E);

            char[] commands = new char[] {
                'f', 'f', 'f', // now at (3,0)
                'l',
                'f', // wrap .. now at (3,10)
                'f', 'f',
                'f',      // OBSTACLE!
                'f'       // OBSTACLE!
            };

            rover.executeCommands(commands, grid);

        } catch (final Exception e) {
        }

    }

}

