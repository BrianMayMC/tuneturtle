package me.nootnoot.mctiersadminbackend.entities.pubsub;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BanRequestObj {
    private final String type = "banrequestobj";
    private String discordId;
}
