package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> songs() {
        return songs;
    }

    public void removeSong(Song song) throws SongDoesNotExistException {
        if (songs.contains(song))
            songs.remove(song);
        else throw new SongDoesNotExistException("Song does not exist in playlist");
    }
}
