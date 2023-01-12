package com.pr.gameserver.domain.usecases.ranking;

import com.pr.gameserver.domain.entries.Ranking;

public interface GetRanksUseCase {
    Iterable<Ranking> getRanksUseCase();
}
