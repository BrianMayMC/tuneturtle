package me.nootnoot.userservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MakeArtistRequest {
    private String username;
    private String artistName;
    private String artistProfilePicture;
}
