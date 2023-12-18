package Repository;

import Domain.Stadium;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StadiumRepository {
    private Connection connection;

    public StadiumRepository(Connection connection) {
        this.connection = connection;
    }

    public StadiumRepository() {
    }

    public void addStadium(Stadium stadium) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO stadiums (name, location) VALUES (?, ?)");
            statement.setString(1, stadium.getName());
            statement.setString(2, stadium.getLocation());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public Stadium getStadiumByName(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM stadiums WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String location = resultSet.getString("location");
                return new Stadium(name, location, null); // Assuming the team information is not retrieved here.
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Stadium> getAllStadiums() {
        List<Stadium> stadiums = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stadiums");

            while (resultSet.next()) {
                String stadiumName = resultSet.getString("name");
                String location = resultSet.getString("location");
                stadiums.add(new Stadium(stadiumName, location, null)); // Assuming the team information is not retrieved here.
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return stadiums;
    }

    public void updateStadium(Stadium updatedStadium) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE stadiums SET location = ? WHERE name = ?");
            statement.setString(1, updatedStadium.getLocation());
            statement.setString(2, updatedStadium.getName());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public void deleteStadium(String name) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM stadiums WHERE name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }
}
