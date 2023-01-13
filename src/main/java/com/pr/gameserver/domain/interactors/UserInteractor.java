package com.pr.gameserver.domain.interactors;

import com.pr.gameserver.application.controller.users.dto.CreateUserDTO;
import com.pr.gameserver.application.controller.users.dto.UserDTO;
import com.pr.gameserver.domain.entries.User;
import com.pr.gameserver.domain.ports.users.UserRepository;
import com.pr.gameserver.domain.usecases.user.AllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserInteractor implements AllUsersUseCase {
    @Autowired
    private UserRepository userRepository;

    public CreateUserDTO addUserUseCase(String name,String email,String password) {
        if(this.findUserByMail(email) == null) {
            User n = new User();
            n.setName(name);
            n.setPassword(password);
            n.setEmail(email);
            userRepository.save(n);

            return new CreateUserDTO(n.getId(), n.getName(), n.getEmail(), n.getPassword());
        }

        // don't tell the user, that user exists (security issue)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong");
    }

    public Iterable<User> getUsersUseCase() {
        return userRepository.findAll();
    }

    public UserDTO loginUseCase(String email, String password) {
        User n = this.findUserByMail(email);

        if (!Objects.isNull(n) && Objects.equals(password, n.getPassword())) {
            return new UserDTO(n.getEmail(), n.getName());
        }

        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Denied");
    }

    private User findUserByMail(String email) {
        return userRepository.findByEmail(email);
    }
}
