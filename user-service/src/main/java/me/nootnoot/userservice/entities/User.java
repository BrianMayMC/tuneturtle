package me.nootnoot.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@AllArgsConstructor
public class User {
    private final UUID id;
    private String name;
    private String email;

    @Setter private UserRole role;

    private RegistrationSource source;

    private final List<UUID> likedSongIds;
    private final Map<UUID, Long> songListenAmounts = new HashMap<>();
    @Setter private boolean artist;
    @Setter private String artistName;
    @Setter private String artistProfilePicture;

    public User(String name, String email, UserRole role, RegistrationSource source){
        this.name = name;
        this.email = email;
        this.role = role;
        this.source = source;
        likedSongIds = new ArrayList<>();
        id = UUID.randomUUID();
    }
}
