package me.nootnoot.playlistservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.playlistservice.entities.Song;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistSongsResponse {
    private final List<Song> songs;
}
