package me.nootnoot.mctiersadminbackend.controller;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.controller.requests.CreateHofRequest;
import me.nootnoot.mctiersadminbackend.entities.HofEntry;
import me.nootnoot.mctiersadminbackend.managers.HofManager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/hof")
@RestController
@RequiredArgsConstructor
public class HofController {

    private final HofManager hofManager;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public void createHof(@Validated @RequestBody CreateHofRequest request){
        System.out.println("request: " + request);
        System.out.println("user: " + request.getUsername());
        hofManager.create(new HofEntry(request.getUsername(), request.getUuid(),
                request.getTimeframe(), request.getTier(), request.getDeed(), request.getType()));
    }

}
