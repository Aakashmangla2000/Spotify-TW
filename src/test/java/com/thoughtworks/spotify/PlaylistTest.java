package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {
    @Test
    void canCreatePlaylist() {
        PlayList playList = new PlayList();

        assertEquals(PlayList.class, playList.getClass());
    }

    @Test
    void canAddSongToPlaylist() {
        PlayList playList = new PlayList();
        Song song = new Song();
        List<Song> expected = Arrays.asList(song);
        playList.addSong(song);

        List<Song> songs = playList.songs();

        assertEquals(expected, songs);
    }

    @Test
    void canDeleteSongFromPlaylist() {
        PlayList playList = new PlayList();
        Song song = new Song();
        List<Song> expected = Arrays.asList();
        playList.addSong(song);
        playList.removeSong(song);

        List<Song> songs = playList.songs();

        assertEquals(expected, songs);
    }
}
