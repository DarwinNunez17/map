//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Repository;

import Domain.Competitions;
import Domain.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompetitionsRepository {
    private Connection connection;

    public CompetitionsRepository(Connection connection) {
        this.connection = connection;
    }

    public CompetitionsRepository() {
    }

    public void addCompetition(Competitions competition) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO competitions (name) VALUES (?)");
            statement.setString(1, competition.getName());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public Competitions getCompetitionByName(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM competitions WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Competitions(name);
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    public List<Competitions> getAllCompetitions() {
        List<Competitions> competitionsList = new ArrayList();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM competitions");

            while(resultSet.next()) {
                String competitionName = resultSet.getString("name");
                competitionsList.add(new Competitions(competitionName));
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return competitionsList;
    }

    public void addTeamToCompetition(String competitionName, Team team) {
    }

    public void deleteCompetition(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM competitions WHERE name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}
