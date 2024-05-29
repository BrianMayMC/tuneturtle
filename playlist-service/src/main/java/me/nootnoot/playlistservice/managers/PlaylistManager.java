package me.nootnoot.playlistservice.managers;

import com.mongodb.client.MongoClient;
import me.nootnoot.playlistservice.entities.Playlist;
import me.nootnoot.playlistservice.entities.Song;
import me.nootnoot.playlistservice.messaging.sender.GetPlaylistSongsSender;
import me.nootnoot.playlistservice.storage.MongoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlaylistManager {

    private List<Playlist> playlists;
    private final MongoManager mongoManager;
    private final GetPlaylistSongsSender getPlaylistSongsSender;

    @Autowired
    public PlaylistManager(MongoManager mongoManager, GetPlaylistSongsSender getPlaylistSongsSender) {
        this.mongoManager = mongoManager;
        this.getPlaylistSongsSender = getPlaylistSongsSender;
        initializePlaylists();
    }

    private void initializePlaylists() {
        this.playlists = mongoManager.getAll();
    }

    public void add(Playlist playlist){
        playlists.add(playlist);
        mongoManager.add(playlist);
    }

    public void remove(UUID id){
        playlists.removeIf(playlist -> playlist.getId().equals(id));
        mongoManager.delete(id);
    }

    public void addSong(UUID playlistId, UUID songId){
        for (Playlist playlist : playlists) {
            if(playlist.getId().equals(playlistId)){
                playlist.getSongIds().add(songId);
                mongoManager.update(playlist);
            }
        }
    }

    public void removeSong(UUID playlistId, UUID songId){
        for (Playlist playlist : playlists) {
            if(playlist.getId().equals(playlistId)){
                playlist.getSongIds().remove(songId);
                mongoManager.update(playlist);
            }
        }
    }

    public List<Playlist> getPlaylists(UUID ownerId){
        List<Playlist> lists = new ArrayList<>();
        for (Playlist playlist : playlists) {
            if(playlist.getOwnerId().equals(ownerId)){
                lists.add(playlist);
            }
        }

        return lists;
    }

    public List<Song> getSongs(UUID playlistId){
        for (Playlist playlist : playlists) {
            if(playlist.getId().equals(playlistId)){
                return getPlaylistSongsSender.getPlaylistSongs(playlist.getSongIds());
            }
        }
        return new ArrayList<>();
    }
}
