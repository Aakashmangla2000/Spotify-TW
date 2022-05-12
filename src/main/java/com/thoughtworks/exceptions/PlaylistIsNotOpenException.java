package com.thoughtworks.exceptions;

public class PlaylistIsNotOpenException extends Exception {
    public PlaylistIsNotOpenException(String message) {
        super(message);
    }
}
