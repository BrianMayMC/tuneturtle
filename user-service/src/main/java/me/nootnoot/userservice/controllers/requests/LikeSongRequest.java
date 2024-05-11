package me.nootnoot.userservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class LikeSongRequest {
    private String username;
    private String songId;
}
