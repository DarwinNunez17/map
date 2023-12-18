//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Repository;

import Domain.Players;
import Domain.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private Connection connection;

    public TeamRepository(Connection connection) {
        this.connection = connection;
    }

    public TeamRepository() {
    }

    public void addTeam(Team team) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO teams (teamID, name) VALUES (?, ?)");
            statement.setInt(1, team.getTeamID());
            statement.setString(2, team.getName());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public Team getTeamByID(int teamID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM teams WHERE teamID = ?");
            statement.setInt(1, teamID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Team(teamID, name);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM teams");

            while(resultSet.next()) {
                int teamID = resultSet.getInt("teamID");
                String name = resultSet.getString("name");
                teams.add(new Team(teamID, name));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return teams;
    }
}
