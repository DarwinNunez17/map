package Repository;

import Domain.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Match getMatchByID(int matchID) {
        for (Match match : matches) {
            if (match.getMatchID() == matchID) {
                return match;
            }
        }
        return null;
    }

    public List<Match> getAllMatches() {
        return matches;
    }


    public void updateMatch(Match updatedMatch) {
        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            if (match.getMatchID() == updatedMatch.getMatchID()) {
                matches.set(i, updatedMatch);
                break;
            }
        }
    }

    public void deleteMatch(int matchID) {
        matches.removeIf(match -> match.getMatchID() == matchID);
    }
}
