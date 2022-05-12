package com.thoughtworks.exceptions;

public class SongAlreadyExistException extends Exception {
    public SongAlreadyExistException(String message) {
        super(message);
    }
}
