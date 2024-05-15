package me.nootnoot.mctiersadminbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HofEntry {
    private String username;
    private String uuid;
    private String timeframe;
    private String tier;
    private String deed;
    private String type;
}
