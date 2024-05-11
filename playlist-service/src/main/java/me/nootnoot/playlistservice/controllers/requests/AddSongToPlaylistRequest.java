package me.nootnoot.playlistservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddSongToPlaylistRequest {
    private String playlistId;
    private String songId;
}
