package me.nootnoot.songservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetLikedSongsMsg {
    private String userId;
    private List<String> songIds;
}
