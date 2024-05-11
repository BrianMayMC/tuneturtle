package me.nootnoot.userservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SongListenRequest {
    private UUID userId;
    private UUID songId;
}
