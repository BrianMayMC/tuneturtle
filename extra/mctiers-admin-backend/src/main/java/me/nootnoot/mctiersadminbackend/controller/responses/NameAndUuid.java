package me.nootnoot.mctiersadminbackend.controller.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class NameAndUuid implements Serializable {
    private String username;
    private String uuid;
    private String reason;
    private String banStatement;
}
