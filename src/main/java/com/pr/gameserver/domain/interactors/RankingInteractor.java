package com.pr.gameserver.domain.interactors;

import com.pr.gameserver.domain.entries.Ranking;
import com.pr.gameserver.domain.entries.User;
import com.pr.gameserver.domain.ports.ranking.RankingRepository;
import com.pr.gameserver.domain.ports.users.UserRepository;
import com.pr.gameserver.domain.usecases.ranking.AllRankingUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class RankingInteractor implements AllRankingUseCases {
    @Autowired
    private RankingRepository rankingRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<Ranking> getRanksUseCase() {
        return rankingRepository.findAll();
    }

    @PostMapping(path="/api/rankings")
    public String updateRankUseCase(Long userId, String points) {
        Ranking rankingEntry = new Ranking();
        Optional<User> user = this.userRepository.findById(userId);

        if (user.isPresent()) {
            rankingEntry.setUser(user.get());
            rankingEntry.setPoints(points);
            rankingRepository.save(rankingEntry);
            return "OK";
        } else {
            return null;
        }
    }

}
