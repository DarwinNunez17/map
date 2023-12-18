package Repository;

import Domain.Referee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RefereeRepository {
    private Connection connection;

    public RefereeRepository(Connection connection) {
        this.connection = connection;
    }

    public RefereeRepository() {
    }

    public void addReferee(Referee referee) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO referees (refereeID, name, nationality, competitionID) VALUES (?, ?, ?, ?)");
            statement.setInt(1, referee.getRefereeID());
            statement.setString(2, referee.getName());
            statement.setString(3, referee.getNationality());
            statement.setInt(4, referee.getCompetitionID());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public Referee getRefereeByID(int refereeID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM referees WHERE refereeID = ?");
            statement.setInt(1, refereeID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                int competitionID = resultSet.getInt("competitionID");
                return new Referee(refereeID, name, nationality, competitionID);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Referee> getAllReferees() {
        List<Referee> referees = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM referees");

            while (resultSet.next()) {
                int refereeID = resultSet.getInt("refereeID");
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                int competitionID = resultSet.getInt("competitionID");
                referees.add(new Referee(refereeID, name, nationality, competitionID));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return referees;
    }

    public void updateReferee(Referee updatedReferee) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE referees SET name = ?, nationality = ?, competitionID = ? WHERE refereeID = ?");
            statement.setString(1, updatedReferee.getName());
            statement.setString(2, updatedReferee.getNationality());
            statement.setInt(3, updatedReferee.getCompetitionID());
            statement.setInt(4, updatedReferee.getRefereeID());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public void deleteReferee(int refereeID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM referees WHERE refereeID = ?");
            statement.setInt(1, refereeID);
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }
}
