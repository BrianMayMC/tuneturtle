package me.nootnoot.mctiersadminbackend.controller;

import me.nootnoot.mctiersadminbackend.entities.DummyDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/dummy")
@RestController
public class DummyController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public DummyDTO getData(){
        return new DummyDTO("Hello there!");
    }
}
