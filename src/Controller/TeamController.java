package Controller;

import Domain.Players;
import Domain.Team;
import Repository.*;

import java.util.List;

public class TeamController {
    private TeamRepository teamRepo;

    public TeamController() {
        this.teamRepo = new TeamRepository(); // Initialize the repository
    }

    public void addTeam(int teamID, String name) {
        Team team = new Team(teamID, name);
        teamRepo.addTeam(team);
    }

    public Team getTeamByID(int teamID) {
        return teamRepo.getTeamByID(teamID);
    }

    public List<Team> getAllTeams() {
        return teamRepo.getAllTeams();
    }

    public void addPlayerToTeam(int teamID, Players player) {
        Team team = teamRepo.getTeamByID(teamID);
        if (team != null) {
            team.addPlayer(player);
        }
    }

}