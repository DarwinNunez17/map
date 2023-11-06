package Repository;


import Domain.*;

import java.util.ArrayList;
import java.util.List;

public class PlayersRepository {
    private List<Players> players = new ArrayList<>();

    public void addPlayer(Players player) {
        players.add(player);
    }

    public Players getPlayerByID(int playerID) {
        for (Players player : players) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null;
    }

    public List<Players> getAllPlayers() {
        return players;
    }

    public void updatePlayer(Players updatedPlayer) {
        for (int i = 0; i < players.size(); i++) {
            Players player = players.get(i);
            if (player.getPlayerID() == updatedPlayer.getPlayerID()) {
                players.set(i, updatedPlayer);
                break;
            }
        }
    }


    public void deletePlayer(int playerID) {
        players.removeIf(player -> player.getPlayerID() == playerID);
    }
}
