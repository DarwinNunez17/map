package Repository;

import Domain.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {
    private Connection connection;

    public ManagerRepository(Connection connection) {
        this.connection = connection;
    }

    public ManagerRepository() {
    }

    public void addManager(Manager manager) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Managers (manager_id, name, nationality, team_id) VALUES (?, ?, ?, ?)");
            statement.setInt(1, manager.getManagerID());
            statement.setString(2, manager.getName());
            statement.setString(3, manager.getNationality());
            statement.setInt(4, manager.getTeamID());
            statement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }

    public Manager getManagerByID(int managerID) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Managers WHERE manager_id = ?");
            statement.setInt(1, managerID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                int teamID = resultSet.getInt("team_id");
                return new Manager(managerID, name, nationality, teamID);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return null;
    }

    public List<Manager> getAllManagers() {
        List<Manager> managers = new ArrayList<>();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Managers");

            while (resultSet.next()) {
                int managerID = resultSet.getInt("manager_id");
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                int teamID = resultSet.getInt("team_id");
                managers.add(new Manager(managerID, name, nationality, teamID));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return managers;
    }
}
