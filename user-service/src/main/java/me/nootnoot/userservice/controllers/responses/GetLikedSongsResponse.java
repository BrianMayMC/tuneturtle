package me.nootnoot.userservice.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.userservice.entities.Song;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetLikedSongsResponse {
    private List<Song> getLikedSongs;
}
