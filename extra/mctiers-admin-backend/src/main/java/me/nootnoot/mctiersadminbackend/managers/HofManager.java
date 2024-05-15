package me.nootnoot.mctiersadminbackend.managers;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.entities.Announcement;
import me.nootnoot.mctiersadminbackend.entities.HofEntry;
import me.nootnoot.mctiersadminbackend.storage.MongoManager;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/hof")
public class HofManager {
    private final MongoManager mongoManager;

    @PostMapping("/")
    public void create(@Validated @RequestBody HofEntry hof){
        mongoManager.addHofCard(hof);
    }
}
