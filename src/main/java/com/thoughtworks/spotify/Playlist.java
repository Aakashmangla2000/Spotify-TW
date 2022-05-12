package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.PlaylistIsNotOpenException;
import com.thoughtworks.exceptions.SongAlreadyExistException;
import com.thoughtworks.exceptions.SongDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> songs = new ArrayList<>();
    boolean openPlaylist;

    public Playlist(boolean open) {
        this.openPlaylist = open;
    }

    public void addSong(Song song) throws SongAlreadyExistException {
        if (!songs.contains(song))
            songs.add(song);
        else throw new SongAlreadyExistException("Song already added in playlist");
    }

    public List<Song> songs() {
        return songs;
    }

    public void removeSong(Song song) throws SongDoesNotExistException {
        if (songs.contains(song))
            songs.remove(song);
        else throw new SongDoesNotExistException("Song does not exist in playlist");
    }

    public List<Song> viewPlaylist() throws PlaylistIsNotOpenException {
        if (openPlaylist == true)
            return songs;
        else
            throw new PlaylistIsNotOpenException("Playlist is private");
    }
}
