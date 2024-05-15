package me.nootnoot.mctiersadminbackend.controller;

import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.entities.UserEntity;
import me.nootnoot.mctiersadminbackend.entities.UserRole;
import me.nootnoot.mctiersadminbackend.managers.UserManager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterIOException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManager userManager;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/makeAdmin/{email}")
    public void changeToAdmin(@PathVariable String email){
        userManager.findByEmail(email)
                .ifPresent(user -> {
                    user.setRole(UserRole.ROLE_ADMIN);
                    userManager.save(user);
                });
    }

    @GetMapping("/isAdmin")
    public boolean isAdmin(@AuthenticationPrincipal OAuth2User principal){
        if(principal == null) return false;
        for(GrantedAuthority authority : principal.getAuthorities()){
            if(authority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")){
                return true;
            }
        }
        return false;
    }
}
