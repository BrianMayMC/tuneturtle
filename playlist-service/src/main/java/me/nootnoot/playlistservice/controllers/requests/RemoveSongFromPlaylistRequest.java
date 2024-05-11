package me.nootnoot.playlistservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RemoveSongFromPlaylistRequest {
    private String playlistId;
    private String songId;
}
