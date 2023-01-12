package com.pr.gameserver.application.controller.users;

import com.pr.gameserver.application.controller.users.dto.CreateUserDTO;
import com.pr.gameserver.application.controller.users.dto.LoginDTO;
import com.pr.gameserver.application.controller.users.dto.UserDTO;
import com.pr.gameserver.domain.entries.User;
import com.pr.gameserver.domain.interactors.UserInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserInteractor userInteractor;

    @PostMapping(path="/api/users") // Map ONLY POST Requests
    public @ResponseBody CreateUserDTO addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userInteractor.addUserUseCase(name, email, password);
    }

    @GetMapping(path="/api/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userInteractor.getUsersUseCase();
    }

    @PostMapping(path="/api/login") // Map ONLY POST Requests
    public @ResponseBody UserDTO login(@RequestBody LoginDTO body) {
        return userInteractor.loginUseCase(body.email, body.password);
    }
}