package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Team;
import com.laborator.FootballDatabase.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamID}")
    public Optional<Team> getTeamById(@PathVariable int teamID) {
        return teamService.getTeamById(teamID);
    }

    @GetMapping("/name/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @DeleteMapping("/{teamID}")
    public void deleteTeamById(@PathVariable int teamID) {
        teamService.deleteTeamById(teamID);
    }
}
