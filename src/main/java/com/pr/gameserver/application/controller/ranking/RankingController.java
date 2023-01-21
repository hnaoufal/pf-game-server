package com.pr.gameserver.application.controller.ranking;

import com.pr.gameserver.application.controller.ranking.dto.UpdateRankingDTO;
import com.pr.gameserver.domain.entities.Ranking;
import com.pr.gameserver.domain.interactors.RankingInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RankingController {

    @Autowired
    private RankingInteractor rankingInteractor;

    @GetMapping(path="/api/rankings")
    public @ResponseBody Iterable<Ranking> getRanks() {
        return rankingInteractor.getRanksUseCase();
    }

    @PostMapping(path="/api/rankings")
    public @ResponseBody String updateRank(@RequestBody UpdateRankingDTO body) {
        return rankingInteractor.updateRankUseCase(body.user, body.getPoints());
    }
}
