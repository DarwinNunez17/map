package UI;

import Domain.*;
import Repository.*;
import Controller.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    public static void ui(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TeamController teamController = new TeamController();
        PlayersController playerController = new PlayersController();
        StadiumController stadiumController = new StadiumController();
        StatisticsController statisticsController = new StatisticsController();
        TransfersController transferController = new TransfersController();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Manage Teams");
            System.out.println("2. Manage Players");
            System.out.println("3. Manage Stadiums");
            System.out.println("4. Manage Statistics");
            System.out.println("5. Manage Transfers");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Team Management:");
                    System.out.println("1. Add Team");
                    System.out.println("2. View All Teams");
                    System.out.println("3. Add Player to Team");

                    int teamOption = scanner.nextInt();
                    switch (teamOption) {
                        case 1:
                            System.out.print("Enter Team ID: ");
                            int teamID = scanner.nextInt();
                            System.out.print("Enter Team Name: ");
                            String teamName = scanner.next();
                            teamController.addTeam(teamID, teamName);
                            break;
                        case 2:
                            List<Team> teams = teamController.getAllTeams();
                            for (Team team : teams) {
                                System.out.println("Team ID: " + team.getTeamID() + ", Name: " + team.getName());
                            }
                            break;
                        case 3:
                            System.out.print("Enter Player ID: ");
                            int playerID = scanner.nextInt();
                            System.out.print("Enter Player Name: ");
                            String playerName = scanner.next();
                            System.out.print("Enter Player Age: ");
                            int playerAge = scanner.nextInt();
                            System.out.print("Enter Player Nationality: ");
                            String playerNationality = scanner.next();
                            System.out.print("Enter Player Position: ");
                            String playerPosition = scanner.next();
                            System.out.print("Enter Team ID: ");
                            int playerTeamID = scanner.nextInt();
                            System.out.print("Enter Player Number: ");
                            int playerNumber = scanner.nextInt();

                            playerController.addPlayer(playerID, playerName, playerAge, playerNationality, playerPosition, playerTeamID, playerNumber);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Player Management:");
                    System.out.println("1. Add Player");
                    System.out.println("2. View All Players");

                    int playerOption = scanner.nextInt();
                    switch (playerOption) {
                        case 1:
                            System.out.print("Enter Player ID: ");
                            int playerID = scanner.nextInt();
                            System.out.print("Enter Player Name: ");
                            String playerName = scanner.next();
                            System.out.print("Enter Player Age: ");
                            int playerAge = scanner.nextInt();
                            System.out.print("Enter Player Nationality: ");
                            String playerNationality = scanner.next();
                            System.out.print("Enter Player Position: ");
                            String playerPosition = scanner.next();
                            System.out.print("Enter Team ID: ");
                            int playerTeamID = scanner.nextInt();
                            System.out.print("Enter Player Number: ");
                            int playerNumber = scanner.nextInt();

                            playerController.addPlayer(playerID, playerName, playerAge, playerNationality, playerPosition, playerTeamID, playerNumber);
                            break;
                        case 2:
                            List<Players> players = playerController.getAllPlayers();
                            for (Players player : players) {
                                System.out.println("Player ID: " + player.getPlayerID() +
                                        ", Name: " + player.getName() +
                                        ", Age: " + player.getAge() +
                                        ", Nationality: " + player.getNationality() +
                                        ", Position: " + player.getPosition() +
                                        ", Team ID: " + player.getTeamID() +
                                        ", Number: " + player.getNumber());
                            }
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Stadium Management:");
                    System.out.println("1. Add Stadium");
                    System.out.println("2. View All Stadiums");

                    int stadiumOption = scanner.nextInt();
                    switch (stadiumOption) {
                        case 1:
                            System.out.print("Enter Stadium Name: ");
                            String stadiumName = scanner.next();
                            System.out.print("Enter Stadium Location: ");
                            String stadiumLocation = scanner.next();

                            System.out.print("Enter Team ID associated with the stadium: ");
                            int teamID = scanner.nextInt();
                            Team stadiumTeam = teamController.getTeamByID(teamID);

                            if (stadiumTeam != null) {
                                stadiumController.addStadium(stadiumName, stadiumLocation, stadiumTeam);
                                System.out.println("Stadium added successfully.");
                            } else {
                                System.out.println("Team with the specified ID not found. Please check the Team ID.");
                            }
                            break;

                        case 2:
                            List<Stadium> stadiums = stadiumController.getAllStadiums();
                            for (Stadium stadium : stadiums) {
                                System.out.println("Stadium Name: " + stadium.getName() + ", Location: " + stadium.getLocation());
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Statistics Management:");
                    System.out.println("1. Add Statistics");
                    System.out.println("2. View All Statistics");

                    int statsOption = scanner.nextInt();
                    switch (statsOption) {
                        case 1:
                            System.out.print("Enter Entity ID: ");
                            int entityId = scanner.nextInt();
                            System.out.print("Goals Scored: ");
                            int goalsScored = scanner.nextInt();
                            System.out.print("Goals Conceded: ");
                            int goalsConceded = scanner.nextInt();
                            System.out.print("Wins: ");
                            int wins = scanner.nextInt();
                            System.out.print("Draws: ");
                            int draws = scanner.nextInt();
                            System.out.print("Losses: ");
                            int losses = scanner.nextInt();
                            statisticsController.addStatistics(entityId, goalsScored, goalsConceded, wins, draws, losses);
                            break;
                        case 2:
                            System.out.print("Enter Entity ID: ");
                            entityId = scanner.nextInt();
                            Statistics entityStats = statisticsController.getStatistics(entityId);

                            if (entityStats != null) {
                                System.out.println("Entity ID: " + entityStats.getEntityId() + ", Goals Scored: " + entityStats.getGoalsScored()
                                        + ", Goals Conceded: " + entityStats.getGoalsConceded() + ", Wins: " + entityStats.getWins()
                                        + ", Draws: " + entityStats.getDraws() + ", Losses: " + entityStats.getLosses());
                            } else {
                                System.out.println("Statistics for the specified Entity ID not found. Please check the Entity ID.");
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Transfer Management:");
                    System.out.println("1. Add Transfer");
                    System.out.println("2. View All Transfers");

                    int transferOption = scanner.nextInt();
                    switch (transferOption) {
                        case 1:
                            System.out.print("Enter Player Name: ");
                            String playerName = scanner.next();

                            System.out.print("Enter Player ID: ");
                            int playerID = scanner.nextInt(); // Add Player ID input

                            System.out.print("Enter Age: ");
                            int age = scanner.nextInt();

                            System.out.print("Enter Nationality: ");
                            String nationality = scanner.next();

                            System.out.print("Enter Position: ");
                            String position = scanner.next();

                            System.out.print("Enter From Team ID: ");
                            int fromTeamID = scanner.nextInt();
                            Team fromTeam = teamController.getTeamByID(fromTeamID);

                            System.out.print("Enter Number: ");
                            int number = scanner.nextInt();

                            System.out.print("Enter To Team ID: ");
                            int toTeamID = scanner.nextInt();
                            Team toTeam = teamController.getTeamByID(toTeamID);

                            System.out.print("Enter Transfer Fee: ");
                            int transferFee = scanner.nextInt();

                            Team team = teamController.getTeamByID(fromTeamID);

                            if (team != null) {
                                Players player = new Players(playerID, playerName, age, nationality, position, toTeamID, number);

                                transferController.addTransfer(player, fromTeam, toTeam, transferFee);
                                System.out.println("Transfer added successfully.");
                            } else {
                                System.out.println("The specified Team ID does not exist. Please check the Team ID.");
                            }
                            break;



                        case 2:
                            List<Transfers> transfers = transferController.getAllTransfers();
                            for (Transfers transfer : transfers) {
                                System.out.println("Player: " + transfer.getPlayer().getName() + ", From Team: " + transfer.getFromTeam().getName()
                                        + ", To Team: " + transfer.getToTeam().getName() + ", Transfer Fee: " + transfer.getTransferFee());
                            }
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
