package me.nootnoot.songservice.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {
    private final int songId;
    private final String name;
    private final int artistId;
    private final String iconImage;
    private final byte[] songData;
    private int listenAmount = 0;

    public Song(int songId, String name, int artistId, String iconImage, byte[] songData) {
        this.songId = songId;
        this.name = name;
        this.artistId = artistId;
        this.iconImage = iconImage;
        this.songData = songData;
    }
}
