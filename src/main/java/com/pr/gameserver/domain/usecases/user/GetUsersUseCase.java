package com.pr.gameserver.domain.usecases.user;

import com.pr.gameserver.domain.entries.User;

public interface GetUsersUseCase {
    Iterable<User> getUsersUseCase();
}
