package me.nootnoot.songservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.songservice.entities.Song;

@Getter
@AllArgsConstructor
public class GetSongResponse {
    private Song song;
}
