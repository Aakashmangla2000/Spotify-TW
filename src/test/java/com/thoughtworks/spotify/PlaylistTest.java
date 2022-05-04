package com.thoughtworks.spotify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {
    @Test
    void canCreatePlaylist(){
        PlayList playList = new PlayList();
        assertEquals(PlayList.class,playList.getClass());
    }
}
