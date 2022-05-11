package com.thoughtworks.exceptions;

public class SongDoesNotExistException extends Exception{
    public SongDoesNotExistException (String message){
        super(message);
    }
}
