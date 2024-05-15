package me.nootnoot.mctiersadminbackend.storage;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.nootnoot.mctiersadminbackend.entities.*;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MongoManager {

    private final MongoCollection<Document> userDataCollection;
    private final MongoCollection<Document> announcementCollection;
    private final MongoCollection<Document> hofCollection;
    private final MongoCollection<Document> discordCodeCollection;
    private final MongoCollection<Document> restrictionCollection;

    private final Map<UUID, Restriction> restrictions = new HashMap<>();

    public MongoManager(){
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://admin:M9ah7SyJ3tfGiDDpY3puMJEw@23.139.82.191:27017/"))
                .uuidRepresentation(UuidRepresentation.STANDARD).build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("mctiers-admin");
        MongoDatabase database2 = mongoClient.getDatabase("mctiers_website");
        MongoDatabase database3 = mongoClient.getDatabase("practice");
        userDataCollection = database.getCollection("user-data");
        announcementCollection = database2.getCollection("announcements_data");
        hofCollection = database2.getCollection("hof_data");
        discordCodeCollection = database3.getCollection("discord_code_data");
        restrictionCollection = database3.getCollection("restriction_data");

        restrictionCollection.find().forEach(document -> {
            restrictions.put(UUID.fromString(document.getString("uuid")), new Restriction(document.getString("reason"),
                    document.getString("ban-statement")));
        });
    }

    public Optional<UserEntity> findUserByEmail(String email){
        Document document = userDataCollection.find(new Document("email", email)).first();
        if(document == null) return Optional.empty();

        return Optional.of(new UserEntity(document.getString("name"), document.getString("email"),
                UserRole.valueOf(document.getString("role")), RegistrationSource.valueOf(document.getString("source"))));
    }

    public Optional<UserEntity> findUserByName(String name){
        Document document = userDataCollection.find(new Document("name", name)).first();
        if(document == null) return Optional.empty();

        return Optional.of(new UserEntity(document.getString("name"), document.getString("email"),
                UserRole.valueOf(document.getString("role")), RegistrationSource.valueOf(document.getString("source"))));
    }

    public void save(UserEntity entity){
        Document document = userDataCollection.find(new Document("name", entity.getName())).first();

        if(document == null){
            userDataCollection.insertOne(new Document("name", entity.getName()).append("email", entity.getEmail())
                    .append("role", entity.getRole()).append("source", entity.getSource()));
        }else{
            userDataCollection.replaceOne(document, new Document("name", entity.getName()).append("email", entity.getEmail())
                    .append("role", entity.getRole()).append("source", entity.getSource()));
        }
    }

    public void addAnnouncement(Announcement announcement){
        Document document = new Document("_id", announcement.getId()).append("title", announcement.getTitle())
                .append("short-description", announcement.getShortDescription())
                .append("description", announcement.getDescription())
                .append("time", announcement.getTime())
                .append("author", announcement.getAuthor())
                .append("uuid", announcement.getUuid())
                .append("image", announcement.getImage());

        announcementCollection.insertOne(document);
    }

    public void addHofCard(HofEntry entry){
        Document document = new Document("username", entry.getUsername())
                .append("uuid", entry.getUuid())
                .append("timeframe", entry.getTimeframe())
                .append("tier", entry.getTier())
                .append("deed", entry.getDeed())
                .append("type", entry.getType());

        hofCollection.insertOne(document);
    }

    public String getDiscordId(UUID uuid){
        Document document = new Document("_id", uuid);
        Document result = discordCodeCollection.find(document).first();

        if(result == null) return "";

        return result.getString("discord-id");
    }

    public void restrict(String username, long duration, String reason, String banStatement, String uuid){
        Document document = new Document("username", username)
                .append("uuid", uuid)
                .append("reason", reason)
                .append("ban-statement", banStatement)
                .append("duration", duration);

        restrictionCollection.insertOne(document);

        restrictions.put(UUID.fromString(uuid), new Restriction(reason, banStatement));
    }

    public Restriction getRestriction(UUID uuid){
        return restrictions.get(uuid);
    }
}
