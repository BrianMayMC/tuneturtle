package me.nootnoot.playlistservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Playlist implements Serializable {
    private final UUID id = UUID.randomUUID();
    private String name;
    private UUID ownerId;
    private List<UUID> songIds;
}
