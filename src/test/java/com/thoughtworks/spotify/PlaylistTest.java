package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongDoesNotExistException;
import org.junit.jupiter.api.Test;

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
        List<Song> expected = List.of(song);
        playList.addSong(song);

        List<Song> songs = playList.songs();

        assertEquals(expected, songs);
    }

    @Test
    void canDeleteSongFromPlaylist() throws SongDoesNotExistException {
        PlayList playList = new PlayList();
        Song song = new Song();
        List<Song> expected = List.of();
        playList.addSong(song);
        playList.removeSong(song);

        List<Song> songs = playList.songs();

        assertEquals(expected, songs);
    }
}
