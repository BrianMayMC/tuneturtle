package me.nootnoot.mctiersadminbackend.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CreateHofRequest implements Serializable {
    private String username;
    private String uuid;
    private String timeframe;
    private String tier;
    private String deed;
    private String type;
}
