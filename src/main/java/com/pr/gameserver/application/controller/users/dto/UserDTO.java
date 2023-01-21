package com.pr.gameserver.application.controller.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserDTO {
    @Getter
    @Setter
    public String email;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public Long id;
}
