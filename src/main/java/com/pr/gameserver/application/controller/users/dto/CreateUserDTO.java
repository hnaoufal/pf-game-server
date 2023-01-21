package com.pr.gameserver.application.controller.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CreateUserDTO {
    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String email;

    @Getter
    @Setter
    public String password;
}
