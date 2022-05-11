package com.thoughtworks.exceptions;

public class PlaylistDoesNotExistException extends Exception {
    public PlaylistDoesNotExistException(String message) {
        super(message);
    }
}
