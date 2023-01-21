package com.pr.gameserver.domain.ports.ranking;

import com.pr.gameserver.domain.entities.Ranking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Integer> { }
