package com.pr.gameserver.domain.ports.users;

import com.pr.gameserver.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {}
