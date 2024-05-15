package me.nootnoot.userservice.controllers;

import me.nootnoot.userservice.controllers.requests.CreateUserRequest;
import me.nootnoot.userservice.controllers.requests.LikeSongRequest;
import me.nootnoot.userservice.controllers.requests.MakeArtistRequest;
import me.nootnoot.userservice.controllers.responses.GetLikedSongsResponse;
import me.nootnoot.userservice.controllers.responses.GetPlaylistsResponse;
import me.nootnoot.userservice.entities.User;
import me.nootnoot.userservice.entities.UserRole;
import me.nootnoot.userservice.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/makeAdmin/{name}")
    public void changeToAdmin(@PathVariable String name){
        userManager.findByName(name)
                .ifPresent(user -> {
                    user.setRole(UserRole.ROLE_ADMIN);
                    userManager.save(user);
                });
    }

    @GetMapping("/isAdmin")
    public boolean isAdmin(@AuthenticationPrincipal OAuth2User principal){
        if(principal == null) return false;
        for(GrantedAuthority authority : principal.getAuthorities()){
            if(authority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")){
                return true;
            }
        }
        return false;
    }

    @GetMapping("/")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @GetMapping("/liked/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public GetLikedSongsResponse getLikedSongs(@PathVariable String username){
        return new GetLikedSongsResponse(userManager.getLikedSongs(username));
    }

    @GetMapping("/playlists/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public GetPlaylistsResponse getPlayLists(@PathVariable String username){
        return new GetPlaylistsResponse(userManager.getPlaylists(username));
    }

    @PutMapping("/artist")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void makeArtist(@RequestBody MakeArtistRequest request){
        userManager.makeArtist(request.getUsername(), request.getArtistName(), request.getArtistProfilePicture());
    }

    @PutMapping("/like")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void likeSong(@RequestBody LikeSongRequest request){
        userManager.addLikedSong(request.getUsername(), UUID.fromString(request.getSongId()));
    }

    @PutMapping("/listen")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void addListen(@RequestBody LikeSongRequest request){
        userManager.addListen(request.getUsername(), UUID.fromString(request.getSongId()));
    }
}
