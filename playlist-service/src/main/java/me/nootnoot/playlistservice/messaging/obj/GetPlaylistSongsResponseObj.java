package me.nootnoot.playlistservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.playlistservice.entities.Song;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistSongsResponseObj implements Serializable {
    private final List<Song> songs;
}
