package Repository;

import Domain.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository<Player> {
    private List<Team> teams = new ArrayList<>();

    public void addTeam(Team team) {
        teams.add(team);
    }

    public Team getTeamByID(int teamID) {
        for (Team team : teams) {
            if (team.getTeamID() == teamID) {
                return team;
            }
        }
        return null;
    }

    public List<Team> getAllTeams() {
        return teams;
    }

    public void addPlayerToTeam(int teamID, Player player) {
        Team team = getTeamByID(teamID);
        if (team != null) {
            team.addPlayer(player);
        }
    }

}