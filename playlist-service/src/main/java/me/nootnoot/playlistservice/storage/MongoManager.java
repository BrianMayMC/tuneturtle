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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MongoManager {

    private final MongoCollection<Document> playlistCollection;

    public MongoManager(){
        String url = System.getenv("MONGODB_URL");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(url != null ? url : "mongodb://localhost:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("playlists");
        playlistCollection = database.getCollection("playlist-data");

        addDummyData();
    }


    private void addDummyData(){
        Document document = playlistCollection.find(new Document("name", "Dummy Playlist")).first();

        if(document == null){
            add(new Playlist("Dummy Playlist", UUID.randomUUID(), List.of(UUID.fromString("aeafc20b-7250-4c16-a3e3-bbcfc89261b7"))));
        }
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

        playlistCollection.replaceOne(current, new Document("_id", playlist.getId())
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
