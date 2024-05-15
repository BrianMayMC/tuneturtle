package me.nootnoot.mctiersadminbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Announcement implements Serializable {
    @Serial private static final long serialVersionUID = 3457626436234L;
    private UUID id;
    private String title;
    private String shortDescription;
    private String description;
    private long time;
    private String author;
    private String uuid;
    private String image;


    public Announcement(String title, String shortDescription, String description, String author, String uuid, String image) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.description = description;
        this.author = author;
        this.uuid = uuid;
        this.image = image;
        time = System.currentTimeMillis();
        id = UUID.randomUUID();
    }
}
