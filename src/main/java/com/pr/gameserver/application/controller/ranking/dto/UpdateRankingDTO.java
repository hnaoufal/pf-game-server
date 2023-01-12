package com.pr.gameserver.application.controller.ranking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UpdateRankingDTO {
    @Getter
    @Setter
    public Long user;

    @Getter
    @Setter
    public String points;
}
