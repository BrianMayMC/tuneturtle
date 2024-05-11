package me.nootnoot.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Song {
    private final UUID id = UUID.randomUUID();
    private UUID artistId;
    private String picture;
    private String title;
    private byte[] songData;
}
