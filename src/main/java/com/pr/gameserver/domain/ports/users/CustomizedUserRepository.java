package com.pr.gameserver.domain.ports.users;

import com.pr.gameserver.domain.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedUserRepository {
    User findByEmail(String email);
}
