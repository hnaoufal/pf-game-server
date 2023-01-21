package com.pr.gameserver.domain.usecases.user;

import com.pr.gameserver.domain.entities.User;

public interface GetUsersUseCase {
    Iterable<User> getUsersUseCase();
}
