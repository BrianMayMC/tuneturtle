package me.nootnoot.userservice.storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.nootnoot.userservice.entities.RegistrationSource;
import me.nootnoot.userservice.entities.User;
import me.nootnoot.userservice.entities.UserRole;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MongoManager {

    private final MongoCollection<Document> userCollection;


    public MongoManager(){
        String url = System.getenv("MONGODB_URL");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(url != null ? url : "mongodb://localhost:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("users");
        userCollection = database.getCollection("user-data");
    }


    public void saveUser(User user){
        Document current = userCollection.find(new Document("name", user.getName())).first();
        if(current == null) {
            userCollection.insertOne(new Document("_id", user.getId())
                    .append("name", user.getName())
                    .append("email", user.getEmail())
                    .append("role", user.getRole())
                    .append("source", user.getSource())
                    .append("likedSongIds", user.getLikedSongIds())
                    .append("songListenAmounts", user.getSongListenAmounts())
                    .append("artist", user.isArtist())
                    .append("artistName", user.getArtistName())
                    .append("artistProfilePicture", user.getArtistProfilePicture()));
        }else{
            userCollection.replaceOne(current, new Document("_id", user.getId())
                    .append("name", user.getName())
                    .append("email", user.getEmail())
                    .append("role", user.getRole())
                    .append("source", user.getSource())
                    .append("likedSongIds", user.getLikedSongIds())
                    .append("songListenAmounts", user.getSongListenAmounts())
                    .append("artist", user.isArtist())
                    .append("artistName", user.getArtistName())
                    .append("artistProfilePicture", user.getArtistProfilePicture()));
        }
    }

    public void updateUser(User user){
        Document current = userCollection.find(new Document("_id", user.getId())).first();
        if(current == null){
            saveUser(user);
            return;
        }

        userCollection.updateOne(current, new Document("_id", user.getId())
                .append("name", user.getName())
                .append("email", user.getEmail())
                .append("role", user.getRole())
                .append("source", user.getSource())
                .append("likedSongIds", user.getLikedSongIds())
                .append("artist", user.isArtist())
                .append("artistName", user.getArtistName())
                .append("artistProfilePicture", user.getArtistProfilePicture()));
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        userCollection.find().forEach(document -> {
            users.add(new User(document.get("_id", UUID.class),
                    document.getString("name"),
                    document.getString("email"),
                    UserRole.valueOf(document.getString("role")),
                    RegistrationSource.valueOf(document.getString("source")),
                    document.getList("likedSongIds", UUID.class),
                    document.getBoolean("artist"),
                    document.getString("artistName"),
                    document.getString("artistProfilePicture")));
        });
        return users;
    }

    public Optional<User> findUserByName(String name){
        Document document = userCollection.find(new Document("name", name)).first();
        if(document == null) return Optional.empty();

        return Optional.of(new User(document.get("_id", UUID.class),
                document.getString("name"),
                document.getString("email"),
                UserRole.valueOf(document.getString("role")),
                RegistrationSource.valueOf(document.getString("source")),
                document.getList("likedSongIds", UUID.class),
                document.getBoolean("artist"),
                document.getString("artistName"),
                document.getString("artistProfilePicture")));
    }


}
