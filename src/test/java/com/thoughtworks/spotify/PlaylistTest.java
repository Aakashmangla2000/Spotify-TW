package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.CannotEditPlaylistException;
import com.thoughtworks.exceptions.PlaylistIsNotOpenException;
import com.thoughtworks.exceptions.SongAlreadyExistException;
import com.thoughtworks.exceptions.SongDoesNotExistException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaylistTest {

    @Test
    void canAddSongToPlaylist() throws SongAlreadyExistException, CannotEditPlaylistException, PlaylistIsNotOpenException {
        User user = new User();
        Playlist Playlist = new Playlist(true, user);
        Song song = new Song();
        List<Song> expected = List.of(song);
        Playlist.addSong(song, user);

        List<Song> songs = Playlist.songs();

        assertEquals(expected, songs);
    }

    @Test
    void shouldNotBeAbleToRemoveSongWhichDoesNotExist() {
        assertThrows(SongDoesNotExistException.class, () -> {
            User user = new User();
            Playlist Playlist = new Playlist(true, user);
            Song song = new Song();
            Playlist.removeSong(song, user);
        });
    }

    @Test
    void canDeleteSongFromPlaylist() throws SongDoesNotExistException, SongAlreadyExistException, CannotEditPlaylistException, PlaylistIsNotOpenException {
        User user = new User();
        Playlist Playlist = new Playlist(true, user);
        Song song = new Song();
        List<Song> expected = List.of();
        Playlist.addSong(song, user);
        Playlist.removeSong(song, user);

        List<Song> songs = Playlist.songs();

        assertEquals(expected, songs);
    }
}
