package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Competitions;
import com.laborator.FootballDatabase.Repository.CompetitionsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CompetitionsService {
    private final CompetitionsRepository competitionsRepository;

    public CompetitionsService(CompetitionsRepository competitionsRepository) {
        this.competitionsRepository = competitionsRepository;
    }

    public List<Competitions> getAllCompetitions() {
        return competitionsRepository.findAll();
    }

    public Competitions getCompetitionByName(int id) {
        return null;
    }

    public void addCompetition(Competitions competition) {
        competitionsRepository.save(competition);
    }

    public void updateCompetition(String name, Competitions updatedCompetition) {
        Competitions existingCompetition = null;
        if (existingCompetition != null) {
            existingCompetition.setName(updatedCompetition.getName());
            existingCompetition.setTeams(updatedCompetition.getTeams());
            competitionsRepository.save(existingCompetition);
        }
    }

    public void deleteCompetition(String name) {
        return;
    }
}