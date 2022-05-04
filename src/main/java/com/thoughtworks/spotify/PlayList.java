package com.thoughtworks.spotify;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    List<Song> songs = new ArrayList<>();
    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> songs() {
        return songs;
    }
}
