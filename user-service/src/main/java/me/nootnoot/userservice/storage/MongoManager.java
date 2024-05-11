package me.nootnoot.userservice.storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.nootnoot.userservice.entities.User;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoManager {

    private final MongoCollection<Document> userCollection;

    public MongoManager(){
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("users");
        userCollection = database.getCollection("user-data");
    }


    public void addUser(User user){
        userCollection.insertOne(new Document("_id", user.getId())
                .append("username", user.getUsername())
                .append("likedSongIds", user.getLikedSongIds())
                .append("songListenAmounts", user.getSongListenAmounts())
                .append("artist", user.isArtist())
                .append("artistName", user.getArtistName())
                .append("artistProfilePicture", user.getArtistProfilePicture()));
    }

    public void updateUser(User user){
        Document current = userCollection.find(new Document("_id", user.getId())).first();
        if(current == null){
            addUser(user);
            return;
        }

        userCollection.updateOne(current, new Document("_id", user.getId())
                .append("username", user.getUsername())
                .append("likedSongIds", user.getLikedSongIds())
                .append("artist", user.isArtist())
                .append("artistName", user.getArtistName())
                .append("artistProfilePicture", user.getArtistProfilePicture()));
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        userCollection.find().forEach(document -> {
            users.add(new User(document.get("_id", UUID.class),
                    document.getString("username"),
                    document.getList("likedSongIds", UUID.class),
                    document.getBoolean("artist"),
                    document.getString("artistName"),
                    document.getString("artistProfilePicture")));
        });
        return users;
    }

}
