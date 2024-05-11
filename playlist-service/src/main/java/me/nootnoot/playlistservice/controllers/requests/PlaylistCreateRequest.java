package me.nootnoot.playlistservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaylistCreateRequest {
    private String name;
    private String owner;
}
