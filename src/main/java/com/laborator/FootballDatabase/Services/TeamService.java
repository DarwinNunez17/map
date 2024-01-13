package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Team;
import com.laborator.FootballDatabase.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public TeamService() {
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(int teamID) {
        return teamRepository.findById((int) teamID);
    }

    public Team getTeamByName(String name) {
//        return teamRepository.findByName(name);
        return null;
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(int teamID) {
        teamRepository.deleteById((int) teamID);
    }
}
