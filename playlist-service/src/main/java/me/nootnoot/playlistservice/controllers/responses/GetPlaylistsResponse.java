package me.nootnoot.playlistservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.playlistservice.entities.Playlist;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistsResponse {
    private final List<Playlist> playlists;
}
