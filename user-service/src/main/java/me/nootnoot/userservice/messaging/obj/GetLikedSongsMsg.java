package me.nootnoot.userservice.messaging.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class GetLikedSongsMsg {
    private String userId;
    private List<String> songIds;
}
