package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.PlaylistAlreadySharedException;
import com.thoughtworks.exceptions.PlaylistDoesNotExistException;

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
        if (this.playlists.contains(playlist) && !user.playlists.contains(playlist))
            user.addPlaylist(playlist);
        else if (!this.playlists.contains(playlist))
            throw new PlaylistDoesNotExistException("Playlist does not exist");
        else
            throw new PlaylistAlreadySharedException("Playlist already shared");
    }

    public Playlist createPlaylist(boolean openPlaylist) {
        Playlist playlist = new Playlist(openPlaylist);
        playlists.add(playlist);
        return playlist;
    }

    public boolean isSharedPlaylist(Playlist playlist) {
        return sharedPlaylists.contains(playlist);
    }
}
