package com.pr.gameserver.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Hicham";
    }

    @GetMapping("/login")
    public String index2() {
        return "Hicham Login";
    }
}
