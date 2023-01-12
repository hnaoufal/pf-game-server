package com.pr.gameserver.domain.usecases.user;

import com.pr.gameserver.application.controller.users.dto.UserDTO;

public interface LoginUseCase {
    UserDTO loginUseCase(String email, String password);
}
