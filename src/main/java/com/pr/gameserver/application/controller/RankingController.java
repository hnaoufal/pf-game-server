package com.pr.gameserver.application.controller;

import com.pr.gameserver.domain.entries.Ranking;
import com.pr.gameserver.infrastructre.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingController {
    @Autowired
    private RankingRepository rankingRepository;

    @GetMapping(path="/api/rankings")
    public @ResponseBody Iterable<Ranking> getAllUsers() {
        return rankingRepository.findAll();
    }
}
