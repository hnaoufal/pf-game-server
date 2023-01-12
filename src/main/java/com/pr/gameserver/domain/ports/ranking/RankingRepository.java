package com.pr.gameserver.domain.ports.ranking;

import com.pr.gameserver.domain.entries.Ranking;
import org.springframework.data.repository.CrudRepository;

public interface RankingRepository extends CrudRepository<Ranking, Integer> {

}
