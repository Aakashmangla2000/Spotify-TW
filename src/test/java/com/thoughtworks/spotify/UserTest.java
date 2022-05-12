package com.thoughtworks.spotify;

import com.thoughtworks.exceptions.PlaylistAlreadySharedException;
import com.thoughtworks.exceptions.PlaylistDoesNotExistException;
import com.thoughtworks.exceptions.PlaylistIsNotOpenException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void userCanViewAnOpenPlaylist() throws PlaylistIsNotOpenException {
        User user1 = new User();
        User user2 = new User();
        Playlist playlist1 = user1.createPlaylist(true);
        Song song1 = new Song();
        playlist1.addSong(song1);

        List<Song> expected = List.of(song1);
        List<Song> songs = user2.viewPlaylist(playlist1);

        assertEquals(expected, songs);
    }
}
