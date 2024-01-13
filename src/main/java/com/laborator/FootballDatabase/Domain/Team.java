package com.laborator.FootballDatabase.Domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Entity
@Table(name = "teams")
public class Team {
    @Id
    private int teamID;
    private String name;
    private List<Players> players;
    public Team(int teamID, String name) {
        this.teamID = teamID;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public Team() {
        this.players = new ArrayList<>();
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