package Domain;

import java.util.List;
import java.util.ArrayList;
public class Competitions {
    private String name;
    private List<Team> teams;

    public Competitions(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }
} 