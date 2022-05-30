package com.thoughtworks.exceptions;

public class CannotEditPlaylistException extends Throwable {
    public CannotEditPlaylistException(String cannot_edit_this_playlist) {
        super(cannot_edit_this_playlist);
    }
}
