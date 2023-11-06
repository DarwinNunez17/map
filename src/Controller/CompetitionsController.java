package Controller;

import Domain.Competitions;
import Domain.Team;
import Repository.CompetitionsRepository;

import java.util.List;
public class CompetitionsController {
    private CompetitionsRepository competitionsRepo;

    public CompetitionsController() {
        this.competitionsRepo = new CompetitionsRepository();
    }

    public void addCompetition(String name) {
        Competitions competition = new Competitions(name);
        competitionsRepo.addCompetition(competition);
    }

    public Competitions getCompetitionByName(String name) {
        return competitionsRepo.getCompetitionByName(name);
    }

    public List<Competitions> getAllCompetitions() {
        return competitionsRepo.getAllCompetitions();
    }

    public void addTeamToCompetition(String competitionName, Team team) {
        Competitions competition = competitionsRepo.getCompetitionByName(competitionName);
        if (competition != null) {
            competition.addTeam(team);
        }
    }

    public void deleteCompetition(String name) {
        competitionsRepo.deleteCompetition(name);
    }
}