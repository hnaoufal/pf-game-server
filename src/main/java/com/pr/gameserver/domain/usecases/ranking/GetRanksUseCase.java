package com.pr.gameserver.domain.usecases.ranking;

import com.pr.gameserver.domain.entities.Ranking;

public interface GetRanksUseCase {
    Iterable<Ranking> getRanksUseCase();
}
