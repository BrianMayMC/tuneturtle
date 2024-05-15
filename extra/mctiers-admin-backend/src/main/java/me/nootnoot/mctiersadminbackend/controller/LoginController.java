package me.nootnoot.mctiersadminbackend.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.nootnoot.mctiersadminbackend.entities.UserRole;
import me.nootnoot.mctiersadminbackend.managers.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
