package com.dl.rover.errors;

public class InvalidCommandException extends Exception {

    public InvalidCommandException(final char command) {

        System.out.println("*** InvalidCommandException: " + command);
    }

}
