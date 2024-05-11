package me.nootnoot.playlistservice.managers;

import me.nootnoot.playlistservice.entities.Playlist;
import me.nootnoot.playlistservice.entities.Song;
import me.nootnoot.playlistservice.messaging.sender.GetPlaylistSongsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlaylistManager {
    private final List<Playlist> playlists = new ArrayList<>();

    @Autowired private GetPlaylistSongsSender getPlaylistSongsSender;

    public void add(Playlist playlist){
        playlists.add(playlist);
    }

    public void remove(UUID id){
        playlists.removeIf(playlist -> playlist.getId().equals(id));
    }

    public void addSong(UUID playlistId, UUID songId){
        for (Playlist playlist : playlists) {
            if(playlist.getId().equals(playlistId)){
                playlist.getSongIds().add(songId);
            }
        }
    }

    public void removeSong(UUID playlistId, UUID songId){
        for (Playlist playlist : playlists) {
            if(playlist.getId().equals(playlistId)){
                playlist.getSongIds().remove(songId);
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
