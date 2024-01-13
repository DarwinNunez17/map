package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Players;
import com.laborator.FootballDatabase.Repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {

    private final PlayersRepository playersRepository;

    @Autowired
    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public List<Players> getAllPlayers() {
        return playersRepository.findAll();
    }

    public Optional<Players> getPlayerById(int playerId) {
        return playersRepository.findById((long) playerId);
    }

    public Players addPlayer(Players player) {
        return playersRepository.save(player);
    }

    public void updatePlayer(int playerId, Players updatedPlayer) {
        Optional<Players> existingPlayer = playersRepository.findById((long) playerId);
        if (existingPlayer.isPresent()) {
            updatedPlayer.setPlayerID(playerId);
            updatedPlayer.setAgeCategoryStrategy(); // Make sure to set the age category strategy
            playersRepository.save(updatedPlayer);
        }
        // Handle not found case if needed
    }

    public void deletePlayer(int playerId) {
        playersRepository.deleteById((long) playerId);
    }
}
