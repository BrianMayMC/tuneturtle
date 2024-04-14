package me.nootnoot.songservice.managers;

import me.nootnoot.songservice.entities.Song;

import java.util.ArrayList;
import java.util.List;

public class SongManager {
    private final List<Song> songs = new ArrayList<>();

    public SongManager(){
        songs.add(new Song(1, "Bohemian Rhapsody", 1,
                "asdf", new byte[]{}));
        // TODO: Add database support
    }

    public Song getSongById(int id){
        return songs.stream().filter(song -> song.getSongId() == id).findFirst().orElse(null);
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void deleteSong(int songId){
        songs.remove(getSongById(songId));
    }

    public int getListenAmount(int songId){
        return getSongById(songId).getListenAmount();
    }

    public void addListen(int songId){
        Song song = getSongById(songId);
        song.setListenAmount(song.getListenAmount() + 1);
    }
}
