//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Repository;

import Domain.Awards;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AwardsRepository {
    private Connection connection;

    public AwardsRepository(Connection connection) {
        this.connection = connection;
    }

    public AwardsRepository() {
    }

    public void addAward(Awards award) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO awards (name, year) VALUES (?, ?)");
            statement.setString(1, award.getName());
            statement.setInt(2, award.getYear());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public Awards getAwardByName(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM awards WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int year = resultSet.getInt("year");
                return new Awards(name, year);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Awards> getAllAwards() {
        List<Awards> awardsList = new ArrayList();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM awards");

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                awardsList.add(new Awards(name, year));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return awardsList;
    }

    public void updateAward(Awards updatedAward) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE awards SET year = ? WHERE name = ?");
            statement.setInt(1, updatedAward.getYear());
            statement.setString(2, updatedAward.getName());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public void deleteAward(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM awards WHERE name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}
