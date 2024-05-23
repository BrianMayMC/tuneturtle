package me.nootnoot.songservice.managers;

import com.mongodb.client.MongoClient;
import me.nootnoot.songservice.entities.Song;
import me.nootnoot.songservice.messaging.sender.GetUserListenAmountSender;
import me.nootnoot.songservice.storage.MongoManager;
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

    private final MongoManager mongoManager;

    public SongManager(){
        mongoManager = new MongoManager();
        songs = mongoManager.getAll();
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
        mongoManager.add(song);
    }

    public void deleteSong(Song song){
        songs.remove(song);
        mongoManager.delete(song);
    }

}
