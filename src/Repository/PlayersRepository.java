package Repository;


import Domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PlayersRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/football";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public void addPlayer(Players player) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO players (playerID, name, age, nationality, position, team_id, number) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, player.getPlayerID());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setInt(3, player.getAge());
            preparedStatement.setString(4, player.getNationality());
            preparedStatement.setString(5, player.getPosition());
            preparedStatement.setInt(6, player.getTeamID());
            preparedStatement.setInt(7, player.getNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Players getPlayerByID(int playerID) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM players WHERE playerID= ?")) {

            preparedStatement.setInt(1, playerID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Players(
                            resultSet.getInt("playerID"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("nationality"),
                            resultSet.getString("position"),
                            resultSet.getInt("team_id"),
                            resultSet.getInt("number")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Players> getAllPlayers() {
        List<Players> players = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM players")) {

            while (resultSet.next()) {
                players.add(new Players(
                        resultSet.getInt("playerID"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("nationality"),
                        resultSet.getString("position"),
                        resultSet.getInt("team_id"),
                        resultSet.getInt("number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    public void updatePlayer(Players updatedPlayer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE players SET name=?, age=?, nationality=?, position=?, team_id=?, number=? WHERE playerID=?")) {

            preparedStatement.setString(1, updatedPlayer.getName());
            preparedStatement.setInt(2, updatedPlayer.getAge());
            preparedStatement.setString(3, updatedPlayer.getNationality());
            preparedStatement.setString(4, updatedPlayer.getPosition());
            preparedStatement.setInt(5, updatedPlayer.getTeamID());
            preparedStatement.setInt(6, updatedPlayer.getNumber());
            preparedStatement.setInt(7, updatedPlayer.getPlayerID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(int playerID) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM players WHERE playerID=?")) {

            preparedStatement.setInt(1, playerID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}