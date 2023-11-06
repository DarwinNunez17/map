package Repository;

import Domain.Competitions;
import Domain.Team;

import java.util.ArrayList;
import java.util.List;

public class CompetitionsRepository {
    private List<Competitions> competitionsList = new ArrayList<>();

    public void addCompetition(Competitions competition) {
        competitionsList.add(competition);
    }

    public Competitions getCompetitionByName(String name) {
        for (Competitions competition : competitionsList) {
            if (competition.getName().equals(name)) {
                return competition;
            }
        }
        return null;
    }

    public List<Competitions> getAllCompetitions() {
        return competitionsList;
    }

    public void addTeamToCompetition(String competitionName, Team team) {
        Competitions competition = getCompetitionByName(competitionName);
        if (competition != null) {
            competition.addTeam(team);
        }
    }

    public void deleteCompetition(String name) {
        competitionsList.removeIf(competition -> competition.getName().equals(name));
    }
}
