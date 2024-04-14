package me.nootnoot.songservicespringboottest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hi")
public class TestController {

    @GetMapping("/")
    public String hello(){
        return "Hey there buddy";
    }
}
