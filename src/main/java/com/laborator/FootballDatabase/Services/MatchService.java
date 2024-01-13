package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Match;
import com.laborator.FootballDatabase.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(int matchId) {
        return matchRepository.findById((long) matchId);
    }

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    public void updateMatch(int matchId, Match updatedMatch) {
        Optional<Match> existingMatch = matchRepository.findById((long) matchId);
        if (existingMatch.isPresent()) {
            updatedMatch.setMatchID(matchId);
            matchRepository.save(updatedMatch);
        }
        // Handle not found case if needed
    }

    public void deleteMatch(int matchId) {
        matchRepository.deleteById((long) matchId);
    }
}
