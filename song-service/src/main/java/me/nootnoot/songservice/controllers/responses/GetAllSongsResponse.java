package me.nootnoot.songservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.songservice.entities.Song;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetAllSongsResponse {
    private final List<Song> songs;
}
