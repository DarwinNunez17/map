import Controller.*;
import Domain.*;
import UI.UI;
import Repository.*;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        runTests();
        if (testsPassed) {
            UI.ui(args);
        }
    }

    private static boolean testsPassed = true;

    private static void runTests() {
        try {

            simulateUITests();

            System.out.println("Toate testele au trecut cu succes.");
        } catch (AssertionError e) {

            testsPassed = false;
            System.err.println("Eroare în timpul testelor: " + e.getMessage());
        }
    }

    private static void simulateUITests() {

        TeamController teamController = new TeamController();
        teamController.addTeam(1, "Echipa A");
        teamController.addTeam(2, "Echipa B");

        List<Team> teams = teamController.getAllTeams();
        assert teams.size() == 2;


        PlayersController playerController = new PlayersController();
        playerController.addPlayer(1, "Jucator 1", 25, "Nationalitate 1", "Atacant", 1, 10);
        playerController.addPlayer(2, "Jucator 2", 28, "Nationalitate 2", "Mijlocaș", 1, 7);

        List<Players> players = playerController.getAllPlayers();
        assert players.size() == 2;


        StadiumController stadiumController = new StadiumController();
        stadiumController.addStadium("Stadion 1", "Locație 1", teams.get(0));
        stadiumController.addStadium("Stadion 2", "Locație 2", teams.get(1));

        List<Stadium> stadiums = stadiumController.getAllStadiums();
        assert stadiums.size() == 2;


        StatisticsController statisticsController = new StatisticsController();
        statisticsController.addStatistics(1, 50, 30, 20, 10, 5);
        statisticsController.addStatistics(2, 40, 25, 15, 12, 8);

        Statistics firstStats = statisticsController.getStatistics(1);
        assert firstStats != null;

        assert firstStats.getGoalsScored() == 50;
        assert firstStats.getGoalsConceded() == 30;
        assert firstStats.getWins() == 20;
        assert firstStats.getDraws() == 10;
        assert firstStats.getLosses() == 5;




        TransfersController transferController = new TransfersController();
        transferController.addTransfer(players.get(0), teams.get(0), teams.get(1), 1000000);
        transferController.addTransfer(players.get(1), teams.get(1), teams.get(0), 800000);

        List<Transfers> transfers = transferController.getAllTransfers();
        assert transfers.size() == 2;

    }

}