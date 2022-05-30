package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.PlaylistAlreadySharedException;
import com.thoughtworks.exceptions.PlaylistDoesNotExistException;
import com.thoughtworks.exceptions.PlaylistIsNotOpenException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Playlist> playlists;
    private List<Playlist> sharedPlaylists;

    public User() {
        playlists = new ArrayList<>();
        sharedPlaylists = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist) {
        this.sharedPlaylists.add(playlist);
    }

    public void sharePlaylist(User user, Playlist playlist) throws PlaylistDoesNotExistException, PlaylistAlreadySharedException {
        if (this.playlists.contains(playlist) && !user.sharedPlaylists.contains(playlist))
            user.addPlaylist(playlist);
        else if (!this.playlists.contains(playlist))
            throw new PlaylistDoesNotExistException("Playlist does not exist");
        else
            throw new PlaylistAlreadySharedException("Playlist already shared");
    }

    public Playlist createPlaylist(boolean openPlaylist) {
        Playlist playlist = new Playlist(openPlaylist, this);
        playlists.add(playlist);
        return playlist;
    }

    public boolean isSharedPlaylist(Playlist playlist) {
        return sharedPlaylists.contains(playlist);
    }

    public List<Song> viewPlaylist(Playlist playlist) throws PlaylistIsNotOpenException {
        return playlist.viewPlaylist();
    }

    public double ratePlaylist(Playlist playlist1, double rating) {
        return playlist1.rate(this, rating);
    }

    public List<Playlist> getMyPlaylists() {
        return playlists;
    }
}
