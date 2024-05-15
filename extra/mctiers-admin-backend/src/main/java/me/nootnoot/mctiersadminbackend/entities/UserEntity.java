package me.nootnoot.mctiersadminbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private String name;
    private String email;

    private UserRole role;

    private RegistrationSource source;
}
