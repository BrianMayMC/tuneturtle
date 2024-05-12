package me.nootnoot.songservice.storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.nootnoot.songservice.entities.Song;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoManager {

    private final MongoCollection<Document> songCollection;

    public MongoManager(){
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://mongodb-service:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("songs");
        songCollection = database.getCollection("song-data");
    }


    public void add(Song song){
        songCollection.insertOne(new Document("_id", song.getId())
                .append("artistId", song.getArtistId())
                .append("picture", song.getPicture())
                .append("title", song.getTitle())
                .append("song-data", song.getSongData()));
    }

    public void update(Song song){
        Document current = songCollection.find(new Document("_id", song.getId())).first();
        if(current == null){
            add(song);
            return;
        }

        songCollection.updateOne(current, new Document("_id", song.getId())
                .append("artistId", song.getArtistId())
                .append("picture", song.getPicture())
                .append("title", song.getTitle())
                .append("song-data", song.getSongData()));
    }

    public List<Song> getAll(){
        List<Song> songs = new ArrayList<>();

        songCollection.find().forEach(document -> {
            songs.add(new Song(document.get("_id", UUID.class), document.get("artistId", UUID.class),
                    document.getString("picture"), document.getString("title"),
                    (byte[])document.get("song-data"), 0));
        });
        return songs;
    }

    public void delete(Song song) {
        songCollection.deleteOne(new Document("_id", song.getId()));
    }
}
