package me.nootnoot.songservice.controllers;

import me.nootnoot.songservice.controllers.requests.CreateSongRequest;
import me.nootnoot.songservice.controllers.responses.GetAllSongsResponse;
import me.nootnoot.songservice.controllers.responses.GetSongResponse;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.managers.SongManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    private SongManager songManager;

    @GetMapping("/")
    public GetAllSongsResponse getAll(){
        return new GetAllSongsResponse(songManager.getAllSongs());
    }

    @GetMapping("/{title}")
    public GetSongResponse getSong(@PathVariable String title){
        return new GetSongResponse(songManager.getSong(title));
    }

    @PostMapping("/")
    public void addSong(@RequestBody CreateSongRequest request){
        try {
            byte[] bytes = request.getSongData().getBytes();
            songManager.addSong(new Song(request.getArtistId(), request.getPictureData(), request.getTitle(), bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{title}")
    public void deleteSong(@PathVariable String title){
        songManager.deleteSong(songManager.getSong(title));
    }


}
