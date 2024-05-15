package me.nootnoot.mctiersadminbackend.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CreateAnnouncementRequest implements Serializable {
    private String title;
    private String shortDescription;
    private String description;
    private String uuid;
    private String author;
    private String image;
}
