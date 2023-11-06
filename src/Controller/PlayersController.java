package Controller;

import Domain.Players;
import Repository.PlayersRepository;

import java.util.List;
public class PlayersController {
    private PlayersRepository playerRepo;

    public PlayersController() {
        this.playerRepo = new PlayersRepository();
    }

    public void addPlayer(int playerID, String name, int age, String nationality, String position, int teamID, int number) {
        Players player = new Players(playerID, name, age, nationality, position, teamID, number);
        playerRepo.addPlayer(player);
    }

    public Players getPlayerByID(int playerID) {
        return playerRepo.getPlayerByID(playerID);
    }

    public List<Players> getAllPlayers() {
        return playerRepo.getAllPlayers();
    }

    public void updatePlayer(int playerID, String name, int age, String nationality, String position, int teamID, int number) {
        Players existingPlayer = playerRepo.getPlayerByID(playerID);
        if (existingPlayer != null) {
            Players updatedPlayer = new Players(playerID, name, age, nationality, position, teamID, number);
            playerRepo.updatePlayer(updatedPlayer);
        }
    }

    public void deletePlayer(int playerID) {
        playerRepo.deletePlayer(playerID);
    }
}