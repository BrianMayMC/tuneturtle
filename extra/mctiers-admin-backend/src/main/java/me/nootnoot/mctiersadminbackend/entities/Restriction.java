package me.nootnoot.mctiersadminbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Restriction {
    private String reason;
    private String statement;
}
