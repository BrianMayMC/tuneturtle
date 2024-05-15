package me.nootnoot.mctiersadminbackend.controller;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.controller.requests.CreateAnnouncementRequest;
import me.nootnoot.mctiersadminbackend.controller.requests.CreateHofRequest;
import me.nootnoot.mctiersadminbackend.entities.Announcement;
import me.nootnoot.mctiersadminbackend.entities.HofEntry;
import me.nootnoot.mctiersadminbackend.managers.AnnouncementManager;
import me.nootnoot.mctiersadminbackend.managers.HofManager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/announcement")
@RestController
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementManager announcementManager;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public void createAnnouncement(@Validated @RequestBody CreateAnnouncementRequest request){
        System.out.println("request: " + request);
        System.out.println("title: " + request.getTitle());
        announcementManager.create(new Announcement(request.getTitle(), request.getShortDescription(), request.getDescription(),
                request.getAuthor(), request.getUuid(), request.getImage()));
    }
}
