package me.nootnoot.mctiersadminbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccessDeniedController {

    @GetMapping("accessDenied")
    public String accessDenied(){
        return "You do not have access to view this page";
    }

}
