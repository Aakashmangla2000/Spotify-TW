package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    void userCanShareAPlaylist() throws PlaylistDoesNotExistException, PlaylistAlreadySharedException {
        User user1 = new User();
        User user2 = new User();
        Playlist playlist1 = user1.createPlaylist(false);

        user1.sharePlaylist(user2, playlist1);

        assertEquals(true, user2.isSharedPlaylist(playlist1));
    }

    @Test
    void userCanViewAnOpenPlaylist() throws PlaylistIsNotOpenException, SongAlreadyExistException, CannotEditPlaylistException {
        User user1 = new User();
        User user2 = new User();
        Playlist playlist1 = user1.createPlaylist(true);
        Song song1 = new Song();
        playlist1.addSong(song1, user1);

        List<Song> expected = List.of(song1);
        List<Song> songs = user2.viewPlaylist(playlist1);

        assertEquals(expected, songs);
    }

    @Test
    void userCanRateAPlaylist() throws SongAlreadyExistException, CannotEditPlaylistException, PlaylistIsNotOpenException {
        User user1 = new User();
        Playlist playlist1 = user1.createPlaylist(true);
        Song song1 = new Song();
        playlist1.addSong(song1, user1);
        double expected = 4.5;

        double rating = user1.ratePlaylist(playlist1, 4.5);

        assertEquals(expected, rating);
    }

    @Test
    void userCanIdentifyTheirOwnPlaylist() {
        User user = new User();
        Playlist playlist = user.createPlaylist(true);
        List<Playlist> expected = List.of(playlist);

        var result = user.getMyPlaylists();

        assertEquals(expected, result);
    }

    @Test
    void userCanIdentifyTheirOwnPlaylist2() {
        User user = new User();
        Playlist playlist = user.createPlaylist(true);

        var result = playlist.createdBy();

        assertEquals(user, result);
    }

    @Test
    void userCanDeleteTheirOwnPlaylist() throws PlaylistDoesNotExistException {
        User user = new User();
        Playlist playlist = user.createPlaylist(true);
        user.deletePlaylist(playlist);
        List<Playlist> playlists = List.of();

        var result = user.getMyPlaylists();

        assertEquals(playlists, result);
    }

    @Test
    void userCannotEditOthersPlaylist() {
        assertThrows(CannotEditPlaylistException.class, () -> {
            User user1 = new User();
            User user2 = new User();
            Playlist playlist = user1.createPlaylist(true);
            Song song = new Song();
            playlist.addSong(song, user2);
        });
    }
}
