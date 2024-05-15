package me.nootnoot.mctiersadminbackend.managers;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.entities.UserEntity;
import me.nootnoot.mctiersadminbackend.storage.MongoManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager {

    private final MongoManager userEntityRepository;

    public Optional<UserEntity> findByEmail(String email){
        return userEntityRepository.findUserByEmail(email);
    }

    public Optional<UserEntity> findByName(String name){
        return userEntityRepository.findUserByName(name);
    }

    public void save(UserEntity user){
        userEntityRepository.save(user);
    }


}
