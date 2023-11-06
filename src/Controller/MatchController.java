package Controller;

import Domain.Match;
import Domain.Team;
import Repository.MatchRepository;

import java.util.List;
import java.util.Date;
public class MatchController {
    private MatchRepository matchRepo;

    public MatchController() {
        this.matchRepo = new MatchRepository();
    }

    public void addMatch(int matchID, Team homeTeam, Team awayTeam, Date matchDate, String location, int scoreHomeTeam, int scoreAwayTeam, int refereeID, int competitionID) {
        Match match = new Match(matchID, homeTeam, awayTeam, matchDate, location, scoreHomeTeam, scoreAwayTeam, refereeID, competitionID);
        matchRepo.addMatch(match);
    }

    public Match getMatchByID(int matchID) {
        return matchRepo.getMatchByID(matchID);
    }

    public List<Match> getAllMatches() {
        return matchRepo.getAllMatches();
    }

    public void updateMatch(int matchID, Team homeTeam, Team awayTeam, Date matchDate, String location, int scoreHomeTeam, int scoreAwayTeam, int refereeID, int competitionID) {
        Match existingMatch = matchRepo.getMatchByID(matchID);
        if (existingMatch != null) {
            Match updatedMatch = new Match(matchID, homeTeam, awayTeam, matchDate, location, scoreHomeTeam, scoreAwayTeam, refereeID, competitionID);
            matchRepo.updateMatch(updatedMatch);
        }
    }

    public void deleteMatch(int matchID) {
        matchRepo.deleteMatch(matchID);
    }

}