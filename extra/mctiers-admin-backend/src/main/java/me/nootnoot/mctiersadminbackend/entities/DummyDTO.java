package me.nootnoot.mctiersadminbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DummyDTO implements Serializable {
    private final String message;

    public DummyDTO(String message){
        this.message = message;
    }

}
