package com.pr.gameserver.domain.usecases;

import lombok.Getter;

public interface LoginUseCase {
    void login(LoginCommand command);

    @Getter
    final class LoginCommand {

    }
}
