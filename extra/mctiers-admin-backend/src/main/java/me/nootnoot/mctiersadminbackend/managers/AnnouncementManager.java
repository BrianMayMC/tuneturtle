package me.nootnoot.mctiersadminbackend.managers;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.entities.Announcement;
import me.nootnoot.mctiersadminbackend.storage.MongoManager;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnnouncementManager {
    private final MongoManager mongoManager;

    public void create(Announcement announcement){
        mongoManager.addAnnouncement(announcement);
    }
}
