package Repository;

import Domain.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsRepository {
    private Connection connection;

    public StatisticsRepository(Connection connection) {
        this.connection = connection;
    }

    public StatisticsRepository() {
    }

    public void addStatistics(int entityId, Statistics statistics) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO statistics (entity_id, goals_scored, goals_conceded, wins, draws, losses) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, entityId);
            statement.setInt(2, statistics.getGoalsScored());
            statement.setInt(3, statistics.getGoalsConceded());
            statement.setInt(4, statistics.getWins());
            statement.setInt(5, statistics.getDraws());
            statement.setInt(6, statistics.getLosses());
            statement.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public Statistics getStatistics(int entityId) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM statistics WHERE entity_id = ?");
            statement.setInt(1, entityId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int goalsScored = resultSet.getInt("goals_scored");
                int goalsConceded = resultSet.getInt("goals_conceded");
                int wins = resultSet.getInt("wins");
                int draws = resultSet.getInt("draws");
                int losses = resultSet.getInt("losses");
                return new Statistics(entityId, goalsScored, goalsConceded, wins, draws, losses);
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return null;
    }

    public void updateStatistics(int entityId, Statistics updatedStatistics) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE statistics SET goals_scored = ?, goals_conceded = ?, wins = ?, draws = ?, losses = ? WHERE entity_id = ?");
            statement.setInt(1, updatedStatistics.getGoalsScored());
            statement.setInt(2, updatedStatistics.getGoalsConceded());
            statement.setInt(3, updatedStatistics.getWins());
            statement.setInt(4, updatedStatistics.getDraws());
            statement.setInt(5, updatedStatistics.getLosses());
            statement.setInt(6, entityId);
            statement.executeUpdate();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }
}
