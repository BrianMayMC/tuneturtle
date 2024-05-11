package me.nootnoot.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@AllArgsConstructor
public class User {
    private final UUID id = UUID.randomUUID();
    private String username;
    private final List<UUID> likedSongIds;
    private final Map<UUID, Long> songListenAmounts = new HashMap<>();
    @Setter private boolean artist;
    @Setter private String artistName;
    @Setter private String artistProfilePicture;

    public User(String username){
        this.username = username;
        likedSongIds = new ArrayList<>();
    }
}
