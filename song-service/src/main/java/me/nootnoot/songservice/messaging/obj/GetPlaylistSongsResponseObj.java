package me.nootnoot.songservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nootnoot.songservice.entities.Song;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistSongsResponseObj implements Serializable {
    private final List<Song> songs;
}
