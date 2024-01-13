import com.laborator.FootballDatabase.Controller.TeamController;
import com.laborator.FootballDatabase.Domain.Awards;
import com.laborator.FootballDatabase.Domain.Competitions;
import com.laborator.FootballDatabase.Domain.Manager;
import com.laborator.FootballDatabase.Repository.AwardsRepository;
import com.laborator.FootballDatabase.Repository.CompetitionsRepository;
import com.laborator.FootballDatabase.Repository.ManagerRepository;
import UI.AwardsUI;
import UI.CompetitionsUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.laborator.FootballDatabase.Factory.*;
public class
Main {
    private static final String URL = "jdbc:mysql://localhost:3306/football";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Connection connection;
        List competitionsList;
        List awardsList;
        List managersList;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "123456");

            try {
                AwardsRepository awardsRepository = new AwardsRepository(connection);
                Awards newAward = new Awards("Best Player", 2022);
                awardsRepository.addAward(newAward);
                Awards retrievedAward = awardsRepository.getAwardByName("Best Player");

                assert retrievedAward != null : "Failed to retrieve the added award";

                assert retrievedAward.getName().equals("Best Player") : "Name mismatch";

                assert retrievedAward.getYear() == 2022 : "Year mismatch";

                awardsList = awardsRepository.getAllAwards();

                Awards updatedAward = new Awards("Best Player", 2023);
                awardsRepository.updateAward(updatedAward);
                retrievedAward = awardsRepository.getAwardByName("Best Player");

                assert retrievedAward != null : "Failed to retrieve the updated award";

                assert retrievedAward.getYear() == 2023 : "Year not updated correctly";

                awardsRepository.deleteAward("Best Player");
                retrievedAward = awardsRepository.getAwardByName("Best Player");

                assert retrievedAward == null : "Failed to delete the award";

                System.out.println("com.laborator.FootballDatabase.Domain.Awards tests passed!");
            } catch (Throwable var14) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var15) {
            var15.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "123456");

            try {
                CompetitionsRepository competitionsRepository = new CompetitionsRepository(connection);
                Competitions newCompetition = new Competitions("Premier League");
                competitionsRepository.addCompetition(newCompetition);
                Competitions retrievedCompetition = competitionsRepository.getCompetitionByName("Premier League");

                assert retrievedCompetition != null : "Failed to retrieve the added competition";

                assert retrievedCompetition.getName().equals("Premier League") : "Name mismatch";

                competitionsList = competitionsRepository.getAllCompetitions();

                assert competitionsList.size() >= 1 : "Unexpected number of competitions in the list";

                competitionsRepository.deleteCompetition("Premier League");
                retrievedCompetition = competitionsRepository.getCompetitionByName("Premier League");

                assert retrievedCompetition == null : "Failed to delete the competition";

                System.out.println("Competition tests passed!");
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var12.addSuppressed(var8);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var13) {
            var13.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "123456");

            try {
                ManagerRepository managerRepository = new ManagerRepository(connection);
                Manager newManager = new Manager(1, "Jose Mourinho", "Portuguese", 10);
                managerRepository.addManager(newManager);
                Manager retrievedManager = managerRepository.getManagerByID(1);

                assert retrievedManager != null : "Failed to retrieve the added manager";

                assert retrievedManager.getName().equals("Jose Mourinho") : "Name mismatch";

                managersList = managerRepository.getAllManagers();

                assert managersList.size() >= 1 : "Unexpected number of managers in the list";

                System.out.println("Manager tests passed!");
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

        CompetitionsUI.ui(args);
        AwardsUI.ui(args);
    }
}
