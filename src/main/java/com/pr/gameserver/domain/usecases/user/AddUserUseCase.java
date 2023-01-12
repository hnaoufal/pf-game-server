package com.pr.gameserver.domain.usecases.user;

import com.pr.gameserver.application.controller.users.dto.CreateUserDTO;

public interface AddUserUseCase {
    CreateUserDTO addUserUseCase(String name, String email, String password);
}
