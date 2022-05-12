package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.SongAlreadyExistException;
import com.thoughtworks.exceptions.SongDoesNotExistException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaylistTest {
    @Test
    void canCreatePlaylist() {
        Playlist Playlist = new Playlist(true);

        assertEquals(Playlist.class, Playlist.getClass());
    }

    @Test
    void canAddSongToPlaylist() throws SongAlreadyExistException {
        Playlist Playlist = new Playlist(true);
        Song song = new Song();
        List<Song> expected = List.of(song);
        Playlist.addSong(song);

        List<Song> songs = Playlist.songs();

        assertEquals(expected, songs);
    }

    @Test
    void shouldNotBeAbleToRemoveSongWhichDoesNotExist() {
        assertThrows(SongDoesNotExistException.class, () -> {
            Playlist Playlist = new Playlist(true);
            Song song = new Song();
            Playlist.removeSong(song);
        });
    }

    @Test
    void canDeleteSongFromPlaylist() throws SongDoesNotExistException, SongAlreadyExistException {
        Playlist Playlist = new Playlist(true);
        Song song = new Song();
        List<Song> expected = List.of();
        Playlist.addSong(song);
        Playlist.removeSong(song);

        List<Song> songs = Playlist.songs();

        assertEquals(expected, songs);
    }
}
