package me.nootnoot.userservice.controllers;

import me.nootnoot.userservice.controllers.requests.CreateUserRequest;
import me.nootnoot.userservice.controllers.requests.LikeSongRequest;
import me.nootnoot.userservice.controllers.requests.MakeArtistRequest;
import me.nootnoot.userservice.controllers.responses.GetLikedSongsResponse;
import me.nootnoot.userservice.controllers.responses.GetPlaylistsResponse;
import me.nootnoot.userservice.entities.User;
import me.nootnoot.userservice.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @PostMapping("/")
    public void createUser(@RequestBody CreateUserRequest request){
        userManager.add(new User(request.getUsername()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userManager.delete(UUID.fromString(id));
    }

    @GetMapping("/liked/{username}")
    public GetLikedSongsResponse getLikedSongs(@PathVariable String username){
        return new GetLikedSongsResponse(userManager.getLikedSongs(username));
    }

    @GetMapping("/playlists/{username}")
    public GetPlaylistsResponse getPlayLists(@PathVariable String username){
        return new GetPlaylistsResponse(userManager.getPlaylists(username));
    }

    @PutMapping("/artist")
    public void makeArtist(@RequestBody MakeArtistRequest request){
        userManager.makeArtist(request.getUsername(), request.getArtistName(), request.getArtistProfilePicture());
    }

    @PutMapping("/like")
    public void likeSong(@RequestBody LikeSongRequest request){
        userManager.addLikedSong(request.getUsername(), UUID.fromString(request.getSongId()));
    }

    @PutMapping("/listen")
    public void addListen(@RequestBody LikeSongRequest request){
        userManager.addListen(request.getUsername(), UUID.fromString(request.getSongId()));
    }
}
