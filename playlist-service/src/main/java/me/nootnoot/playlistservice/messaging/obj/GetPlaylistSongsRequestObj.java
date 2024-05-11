package me.nootnoot.playlistservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetPlaylistSongsRequestObj implements Serializable {
    private final List<String> songIds;
}
