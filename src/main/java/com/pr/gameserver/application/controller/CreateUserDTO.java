package com.pr.gameserver.application.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CreateUserDTO {
    @Getter
    @Setter
    public Integer id;

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String email;
}
