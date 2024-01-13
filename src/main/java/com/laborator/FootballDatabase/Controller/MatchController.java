package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Match;
import com.laborator.FootballDatabase.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Optional<Match> getMatchById(@PathVariable int id) {
        return matchService.getMatchById(id);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchService.addMatch(match);
    }

    @PutMapping("/{id}")
    public void updateMatch(@PathVariable int id, @RequestBody Match updatedMatch) {
        matchService.updateMatch(id, updatedMatch);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable int id) {
        matchService.deleteMatch(id);
    }
}
