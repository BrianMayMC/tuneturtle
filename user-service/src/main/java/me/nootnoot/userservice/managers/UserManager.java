package me.nootnoot.userservice.managers;

import com.mongodb.client.MongoClient;
import me.nootnoot.userservice.entities.Playlist;
import me.nootnoot.userservice.entities.User;
import me.nootnoot.userservice.entities.Song;
import me.nootnoot.userservice.messaging.sender.UserLikedSongsMessageSender;
import me.nootnoot.userservice.messaging.sender.UserPlaylistMessageSender;
import me.nootnoot.userservice.storage.MongoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserManager {
    private final List<User> users;
    private final MongoManager mongoManager;

    @Autowired
    private UserPlaylistMessageSender messageHandler;
    @Autowired
    private UserLikedSongsMessageSender userLikedSongsMessageSender;

    public UserManager(){
        mongoManager = new MongoManager();
        users = mongoManager.getUsers();
    }

    public void addLikedSong(String username, UUID songId){
        users.forEach(user -> {
            if(user.getUsername().equalsIgnoreCase(username)){
                user.getLikedSongIds().add(songId);
                mongoManager.updateUser(user);
            }
        });
    }

    public List<Song> getLikedSongs(String username){
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return userLikedSongsMessageSender.getLikedSongs(user.getId(), user.getLikedSongIds());
            }
        }
        return null;
    }

    public List<Playlist> getPlaylists(String username){
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return messageHandler.getUserPlaylists(user.getId());
            }
        }
        return new ArrayList<>();
    }

    public User getUser(String username){
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

    public void add(User user){
        System.out.println("adding user");
        users.add(user);
        mongoManager.addUser(user);
    }

    public void makeArtist(String username, String artistName, String artistProfilePicture){
        users.forEach(user -> {
            if(user.getUsername().equalsIgnoreCase(username)){
                user.setArtist(true);
                user.setArtistName(artistName);
                user.setArtistProfilePicture(artistProfilePicture);
                mongoManager.updateUser(user);
            }
        });
    }

    public void addListen(String username, UUID songId) {
        for (User user : users) {
            if(user.getUsername().equalsIgnoreCase(username)){
                user.getSongListenAmounts().put(songId, user.getSongListenAmounts().getOrDefault(songId, 0L) + 1);
                mongoManager.updateUser(user);
            }
        }
    }

    public int getListenAmounts(UUID songId) {
        int amount = 0;
        for(User user : users){
            amount += user.getSongListenAmounts().getOrDefault(songId, 0L);
        }
        return amount;
    }

    public boolean isAdmin(String username){
        return false;
    }

    public boolean isArtist(String username){
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.isArtist()){
                return true;
            }
        }
        return false;
    }
}
