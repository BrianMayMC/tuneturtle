package me.nootnoot.mctiersadminbackend.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class CreateRestrictionRequest implements Serializable {
    private String username;
    private long duration;
    private String reason;
    private String banStatement;
    private String uuid;
}
