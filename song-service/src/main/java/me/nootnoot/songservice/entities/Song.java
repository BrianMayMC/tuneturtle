package me.nootnoot.songservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Getter
public class Song {
    private final UUID id = UUID.randomUUID();
    private final UUID artistId;
    private final String picture;
    private final String title;
    private final byte[] songData;

    @Setter private int listenAmount = 0;

    public Song(UUID artistId, String picture, String title, byte[] songData) {
        this.artistId = artistId;
        this.picture = picture;
        this.title = title;
        this.songData = songData;
    }
}
