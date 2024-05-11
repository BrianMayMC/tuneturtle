package me.nootnoot.userservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.userservice.entities.Playlist;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistsResponse {
    private List<Playlist> playlists;
}
