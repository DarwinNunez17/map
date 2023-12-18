package Repository;

import Domain.Match;
import Domain.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private Connection connection;

    public MatchRepository(Connection connection) {
        this.connection = connection;
    }

    public MatchRepository() {
    }

    public void addMatch(Match match) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO matches (matchID, homeTeamID, awayTeamID, matchDate, location, scoreHomeTeam, scoreAwayTeam, refereeID, competitionID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, match.getMatchID());
            statement.setInt(2, match.getHomeTeamID().getTeamID());
            statement.setInt(3, match.getAwayTeamID().getTeamID());
            statement.setDate(4, new java.sql.Date(match.getMatchDate().getTime()));
            statement.setString(5, match.getLocation());
            statement.setInt(6, match.getScoreHomeTeam());
            statement.setInt(7, match.getScoreAwayTeam());
            statement.setInt(8, match.getRefereeID());
            statement.setInt(9, match.getCompetitionID());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public Match getMatchByID(int matchID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM matches WHERE matchID = ?");
            statement.setInt(1, matchID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int homeTeamID = resultSet.getInt("homeTeamID");
                int awayTeamID = resultSet.getInt("awayTeamID");
                java.util.Date matchDate = resultSet.getDate("matchDate");
                String location = resultSet.getString("location");
                int scoreHomeTeam = resultSet.getInt("scoreHomeTeam");
                int scoreAwayTeam = resultSet.getInt("scoreAwayTeam");
                int refereeID = resultSet.getInt("refereeID");
                int competitionID = resultSet.getInt("competitionID");

                // Directly retrieve Team objects from the database based on team IDs.
                Team homeTeam = retrieveTeamByID(homeTeamID);
                Team awayTeam = retrieveTeamByID(awayTeamID);

                return new Match(matchID, homeTeam, awayTeam, matchDate, location, scoreHomeTeam, scoreAwayTeam, refereeID, competitionID);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM matches");

            while (resultSet.next()) {
                int matchID = resultSet.getInt("matchID");
                int homeTeamID = resultSet.getInt("homeTeamID");
                int awayTeamID = resultSet.getInt("awayTeamID");
                java.util.Date matchDate = resultSet.getDate("matchDate");
                String location = resultSet.getString("location");
                int scoreHomeTeam = resultSet.getInt("scoreHomeTeam");
                int scoreAwayTeam = resultSet.getInt("scoreAwayTeam");
                int refereeID = resultSet.getInt("refereeID");
                int competitionID = resultSet.getInt("competitionID");

                // Directly retrieve Team objects from the database based on team IDs.
                Team homeTeam = retrieveTeamByID(homeTeamID);
                Team awayTeam = retrieveTeamByID(awayTeamID);

                matches.add(new Match(matchID, homeTeam, awayTeam, matchDate, location, scoreHomeTeam, scoreAwayTeam, refereeID, competitionID));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return matches;
    }

    public void updateMatch(Match updatedMatch) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE matches SET homeTeamID = ?, awayTeamID = ?, matchDate = ?, location = ?, scoreHomeTeam = ?, scoreAwayTeam = ?, refereeID = ?, competitionID = ? WHERE matchID = ?");
            statement.setInt(1, updatedMatch.getHomeTeamID().getTeamID());
            statement.setInt(2, updatedMatch.getAwayTeamID().getTeamID());
            statement.setDate(3, new java.sql.Date(updatedMatch.getMatchDate().getTime()));
            statement.setString(4, updatedMatch.getLocation());
            statement.setInt(5, updatedMatch.getScoreHomeTeam());
            statement.setInt(6, updatedMatch.getScoreAwayTeam());
            statement.setInt(7, updatedMatch.getRefereeID());
            statement.setInt(8, updatedMatch.getCompetitionID());
            statement.setInt(9, updatedMatch.getMatchID());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public void deleteMatch(int matchID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM matches WHERE matchID = ?");
            statement.setInt(1, matchID);
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    // Implement this method to retrieve Team objects from the database based on team IDs.
    private Team retrieveTeamByID(int teamID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM teams WHERE teamID = ?");
            statement.setInt(1, teamID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String teamName = resultSet.getString("name");

                return new Team(teamID, teamName);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return null;
    }
}
