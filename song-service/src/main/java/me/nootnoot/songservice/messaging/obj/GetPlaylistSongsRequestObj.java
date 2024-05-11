package me.nootnoot.songservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetPlaylistSongsRequestObj implements Serializable {
    private final List<String> songIds;
}
