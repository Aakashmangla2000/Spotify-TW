package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.CannotEditPlaylistException;
import com.thoughtworks.exceptions.PlaylistIsNotOpenException;
import com.thoughtworks.exceptions.SongAlreadyExistException;
import com.thoughtworks.exceptions.SongDoesNotExistException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Playlist {
    List<Song> songs = new ArrayList<>();
    boolean openPlaylist;
    HashMap<User, Double> ratings;
    User user;

    public Playlist(boolean open, User user) {
        this.user = user;
        this.openPlaylist = open;
        this.ratings = new HashMap<>();
    }

    public void addSong(Song song, User user) throws SongAlreadyExistException, CannotEditPlaylistException {
        if (this.user == user) {
            if (!songs.contains(song))
                songs.add(song);
            else throw new SongAlreadyExistException("Song already added in playlist");
        } else
            throw new CannotEditPlaylistException("Cannot edit this playlist");
    }

    public List<Song> songs() {
        return songs;
    }

    public void removeSong(Song song, User user) throws SongDoesNotExistException, CannotEditPlaylistException {
        if (this.user == user) {
            if (songs.contains(song))
                songs.remove(song);
            else throw new SongDoesNotExistException("Song does not exist in playlist");
        } else
            throw new CannotEditPlaylistException("Cannot edit this playlist");
    }

    public List<Song> viewPlaylist() throws PlaylistIsNotOpenException {
        if (openPlaylist)
            return songs;
        else
            throw new PlaylistIsNotOpenException("Playlist is private");
    }

    public double rate(User user, double rating) {
        if (ratings.containsKey(user))
            ratings.replace(user, rating);
        else
            ratings.put(user, rating);
        double sum = 0;
        for (var entry : ratings.entrySet()) {
            sum += entry.getValue();
        }
        return sum / ratings.size();
    }

    public User createdBy() {
        return user;
    }
}
