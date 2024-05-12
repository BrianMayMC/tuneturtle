package me.nootnoot.playlistservice.storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.nootnoot.playlistservice.entities.Playlist;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoManager {

    private final MongoCollection<Document> playlistCollection;

    public MongoManager(){
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://mongodb-service:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("playlists");
        playlistCollection = database.getCollection("playlist-data");
    }


    public void add(Playlist playlist){
        playlistCollection.insertOne(new Document("_id", playlist.getId())
                .append("name", playlist.getName())
                .append("ownerId", playlist.getOwnerId())
                .append("song-ids", playlist.getSongIds()));
    }

    public void update(Playlist playlist){
        Document current = playlistCollection.find(new Document("_id", playlist.getId())).first();
        if(current == null){
            add(playlist);
            return;
        }

        playlistCollection.updateOne(current, new Document("_id", playlist.getId())
                .append("name", playlist.getName())
                .append("ownerId", playlist.getOwnerId())
                .append("song-ids", playlist.getSongIds()));
    }

    public List<Playlist> getAll(){
        List<Playlist> playlists = new ArrayList<>();

        playlistCollection.find().forEach(document -> {
            playlists.add(new Playlist(document.get("_id", UUID.class),
                    document.getString("name"),
                    document.get("ownerId", UUID.class),
                    document.getList("song-ids", UUID.class)
            ));
        });
        return playlists;
    }


    public void delete(UUID id){
        playlistCollection.deleteOne(new Document("_id", id));
    }
}
