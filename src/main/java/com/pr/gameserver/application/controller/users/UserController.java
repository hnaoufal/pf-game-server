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
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // Prüfung, ob die Emailadresse bereit in der Datenbank vorhanden ist
        if(userInteractor.checkUserUnique(email)){
            userInteractor.addUserUseCase(name, email, password); // Neuen Benutzer in der Datenbank anlegen
            return "Neuer Benutzer erfolgreich angelegt!";
        }
        else{
            return "Dieser Benutzer existiert bereits!";
        }
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
