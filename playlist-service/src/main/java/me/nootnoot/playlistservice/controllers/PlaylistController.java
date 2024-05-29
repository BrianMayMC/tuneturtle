package me.nootnoot.playlistservice.controllers;

import me.nootnoot.playlistservice.controllers.requests.AddSongToPlaylistRequest;
import me.nootnoot.playlistservice.controllers.requests.PlaylistCreateRequest;
import me.nootnoot.playlistservice.controllers.requests.RemoveSongFromPlaylistRequest;
import me.nootnoot.playlistservice.controllers.responses.GetPlaylistSongsResponse;
import me.nootnoot.playlistservice.controllers.responses.GetPlaylistsResponse;
import me.nootnoot.playlistservice.entities.Playlist;
import me.nootnoot.playlistservice.managers.PlaylistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired private PlaylistManager playlistManager;

    @PostMapping("/")
    public void add(@RequestBody PlaylistCreateRequest request){
        playlistManager.add(new Playlist(request.getName(), UUID.fromString(request.getOwner()), new ArrayList<>()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        playlistManager.remove(UUID.fromString(id));
    }


    @PutMapping("/song")
    public void addSong(@RequestBody AddSongToPlaylistRequest request){
        playlistManager.addSong(UUID.fromString(request.getPlaylistId()), UUID.fromString(request.getSongId()));
    }

    @DeleteMapping("/song")
    public void removeSong(@RequestBody RemoveSongFromPlaylistRequest request){
        playlistManager.removeSong(UUID.fromString(request.getPlaylistId()), UUID.fromString(request.getSongId()));
    }

    @GetMapping("/{id}")
    public GetPlaylistsResponse getPlaylistsByUser(@PathVariable String id){
        return new GetPlaylistsResponse(playlistManager.getPlaylists(UUID.fromString(id)));
    }

    @GetMapping("/")
    public GetPlaylistsResponse getPlaylists(){
        return new GetPlaylistsResponse(playlistManager.getAll());
    }

    @GetMapping("/songs/{id}")
    public GetPlaylistSongsResponse getSongs(@PathVariable String id){
        return new GetPlaylistSongsResponse(playlistManager.getSongs(UUID.fromString(id)));
    }
}
