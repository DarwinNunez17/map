package Domain;

import Domain.Players;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamID;
    private String name;
    private List<Players> players;
    private static Team instance;
    public Team(int teamID, String name) {
        this.teamID = teamID;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public static Team getInstance(int teamID, String name){
        if (instance==null){
            instance=new Team(teamID, name);
        }
        return instance;
    }
    public int getTeamID() {
        return teamID;
    }

    public String getName() {
        return name;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void addPlayer(Players player) {
        players.add(player);
    }
}