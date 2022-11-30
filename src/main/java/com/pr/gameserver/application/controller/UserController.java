package com.pr.gameserver.application.controller;

import com.pr.gameserver.domain.entries.User;
import com.pr.gameserver.infrastructre.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/api/users") // Map ONLY POST Requests
    public @ResponseBody CreateUserDTO addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setEmail(email);
        userRepository.save(n);

        return new CreateUserDTO(n.getId(), n.getName(), n.getEmail());
    }

    @GetMapping(path="/api/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/api/login") // Map ONLY POST Requests
    public @ResponseBody String login(@RequestParam String email, @RequestParam String password) {
        return "Greetings from Hicham";
    }
}
