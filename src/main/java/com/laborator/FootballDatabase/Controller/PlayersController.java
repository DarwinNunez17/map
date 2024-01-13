package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Players;
import com.laborator.FootballDatabase.Services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayersController {

    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping
    public List<Players> getAllPlayers() {
        return playersService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Players> getPlayerById(@PathVariable int id) {
        return playersService.getPlayerById(id);
    }

    @PostMapping
    public Players addPlayer(@RequestBody Players player) {
        return playersService.addPlayer(player);
    }

    @PutMapping("/{id}")
    public void updatePlayer(@PathVariable int id, @RequestBody Players updatedPlayer) {
        playersService.updatePlayer(id, updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        playersService.deletePlayer(id);
    }
}
