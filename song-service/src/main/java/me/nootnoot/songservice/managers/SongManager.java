package me.nootnoot.songservice.managers;

import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.messaging.sender.GetUserListenAmountSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SongManager {
    private final List<Song> songs = new ArrayList<>();

    @Autowired
    private GetUserListenAmountSender getUserListenAmountSender;

    public SongManager(){
        songs.add(new Song(UUID.randomUUID(), "", "Bohemian Rhapsody", new byte[]{}));
    }

    public Song getSong(String title){
        for(Song song : songs){
            if(song.getTitle().equalsIgnoreCase(title)){
                song.setListenAmount(getListenAmount(song.getId()));
                return song;
            }
        }
        return null;
    }

    public Song getSong(UUID id){
        for(Song song : songs){
            if(song.getId().equals(id)){
                song.setListenAmount(getListenAmount(id));
                return song;
            }
        }
        return null;
    }

    public List<Song> getAllSongs(){
        for(Song song : songs) {
            song.setListenAmount(getListenAmount(song.getId()));
        }
        return songs;
    }

    public int getListenAmount(UUID songId){
        return getUserListenAmountSender.getListenAmount(songId);
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void deleteSong(Song song){
        songs.remove(song);
    }

}
