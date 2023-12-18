//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package UI;

import Controller.PlayersController;
import Controller.StadiumController;
import Controller.StatisticsController;
import Controller.TeamController;
import Controller.TransfersController;
import Domain.Players;
import Domain.Stadium;
import Domain.Statistics;
import Domain.Team;
import Domain.Transfers;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UI {
    public UI() {
    }

    public static void ui(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeamController teamController = new TeamController();
        PlayersController playerController = new PlayersController();
        StadiumController stadiumController = new StadiumController();
        StatisticsController statisticsController = new StatisticsController();
        TransfersController transferController = new TransfersController();

        while(true) {
            while(true) {
                label75:
                while(true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Manage Teams");
                    System.out.println("2. Manage Players");
                    System.out.println("3. Manage Stadiums");
                    System.out.println("4. Manage Statistics");
                    System.out.println("5. Manage Transfers");
                    System.out.println("6. Exit");
                    int choice = scanner.nextInt();
                    int teamID;
                    int playerID;
                    int entityId;
                    String playerName;
                    int age;
                    PrintStream var10000;
                    String nationality;
                    int var10001;
                    int fromTeamID;
                    String stadiumName;
                    int goalsScored;
                    int draws;
                    int losses;
                    int var42;
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
                                    teamID = scanner.nextInt();
                                    System.out.print("Enter Team Name: ");
                                    String teamName = scanner.next();
                                    teamController.addTeam(teamID, teamName);
                                    continue;
                                case 2:
                                    List<Team> teams = teamController.getAllTeams();
                                    Iterator var33 = teams.iterator();

                                    while(true) {
                                        if (!var33.hasNext()) {
                                            continue label75;
                                        }

                                        Team team = (Team)var33.next();
                                        var10000 = System.out;
                                        var42 = team.getTeamID();
                                        var10000.println("Team ID: " + var42 + ", Name: " + team.getName());
                                    }
                                case 3:
                                    System.out.print("Enter Player ID: ");
                                    entityId = scanner.nextInt();
                                    System.out.print("Enter Player Name: ");
                                    playerName = scanner.next();
                                    System.out.print("Enter Player Age: ");
                                    playerID = scanner.nextInt();
                                    System.out.print("Enter Player Nationality: ");
                                    String playerNationality = scanner.next();
                                    System.out.print("Enter Player Position: ");
                                    nationality = scanner.next();
                                    System.out.print("Enter Team ID: ");
                                    losses = scanner.nextInt();
                                    System.out.print("Enter Player Number: ");
                                    fromTeamID = scanner.nextInt();
                                    playerController.addPlayer(entityId, playerName, playerID, playerNationality, nationality, losses, fromTeamID);
                                default:
                                    continue;
                            }
                        case 2:
                            System.out.println("Player Management:");
                            System.out.println("1. Add Player");
                            System.out.println("2. View All Players");
                            teamID = scanner.nextInt();
                            switch (teamID) {
                                case 1:
                                    System.out.print("Enter Player ID: ");
                                    playerID = scanner.nextInt();
                                    System.out.print("Enter Player Name: ");
                                    stadiumName = scanner.next();
                                    System.out.print("Enter Player Age: ");
                                    entityId = scanner.nextInt();
                                    System.out.print("Enter Player Nationality: ");
                                    playerName = scanner.next();
                                    System.out.print("Enter Player Position: ");
                                    String playerPosition = scanner.next();
                                    System.out.print("Enter Team ID: ");
                                    age = scanner.nextInt();
                                    System.out.print("Enter Player Number: ");
                                    draws = scanner.nextInt();
                                    playerController.addPlayer(playerID, stadiumName, entityId, playerName, playerPosition, age, draws);
                                    continue;
                                case 2:
                                    List<Players> players = playerController.getAllPlayers();
                                    Iterator var46 = players.iterator();

                                    while(var46.hasNext()) {
                                        Players player = (Players)var46.next();
                                        var10000 = System.out;
                                        var42 = player.getPlayerID();
                                        var10000.println("Player ID: " + var42 + ", Name: " + player.getName() + ", Age: " + player.getAge() + ", Nationality: " + player.getNationality() + ", Position: " + player.getPosition() + ", Team ID: " + player.getTeamID() + ", Number: " + player.getNumber() + ", Age Category: " + player.getAgeCategory());
                                    }
                                default:
                                    continue;
                            }
                        case 3:
                            System.out.println("Stadium Management:");
                            System.out.println("1. Add Stadium");
                            System.out.println("2. View All Stadiums");
                            playerID = scanner.nextInt();
                            switch (playerID) {
                                case 1:
                                    System.out.print("Enter Stadium Name: ");
                                    stadiumName = scanner.next();
                                    System.out.print("Enter Stadium Location: ");
                                    String stadiumLocation = scanner.next();
                                    System.out.print("Enter Team ID associated with the stadium: ");
                                    goalsScored = scanner.nextInt();
                                    Team stadiumTeam = teamController.getTeamByID(goalsScored);
                                    if (stadiumTeam != null) {
                                        stadiumController.addStadium(stadiumName, stadiumLocation, stadiumTeam);
                                        System.out.println("Stadium added successfully.");
                                    } else {
                                        System.out.println("Team with the specified ID not found. Please check the Team ID.");
                                    }
                                    continue;
                                case 2:
                                    List<Stadium> stadiums = stadiumController.getAllStadiums();
                                    Iterator var40 = stadiums.iterator();

                                    while(var40.hasNext()) {
                                        Stadium stadium = (Stadium)var40.next();
                                        var10000 = System.out;
                                        var10001 = Integer.parseInt(stadium.getName());
                                        var10000.println("Stadium Name: " + var10001 + ", Location: " + stadium.getLocation());
                                    }
                                default:
                                    continue;
                            }
                        case 4:
                            System.out.println("Statistics Management:");
                            System.out.println("1. Add Statistics");
                            System.out.println("2. View All Statistics");
                            int statsOption = scanner.nextInt();
                            switch (statsOption) {
                                case 1:
                                    System.out.print("Enter Entity ID: ");
                                    entityId = scanner.nextInt();
                                    System.out.print("Goals Scored: ");
                                    goalsScored = scanner.nextInt();
                                    System.out.print("Goals Conceded: ");
                                    playerID = scanner.nextInt();
                                    System.out.print("Wins: ");
                                    age = scanner.nextInt();
                                    System.out.print("Draws: ");
                                    draws = scanner.nextInt();
                                    System.out.print("Losses: ");
                                    losses = scanner.nextInt();
                                    statisticsController.addStatistics(entityId, goalsScored, playerID, age, draws, losses);
                                    continue;
                                case 2:
                                    System.out.print("Enter Entity ID: ");
                                    entityId = scanner.nextInt();
                                    Statistics entityStats = statisticsController.getStatistics(entityId);
                                    if (entityStats != null) {
                                        var10000 = System.out;
                                        var42 = entityStats.getEntityId();
                                        var10000.println("Entity ID: " + var42 + ", Goals Scored: " + entityStats.getGoalsScored() + ", Goals Conceded: " + entityStats.getGoalsConceded() + ", Wins: " + entityStats.getWins() + ", Draws: " + entityStats.getDraws() + ", Losses: " + entityStats.getLosses());
                                    } else {
                                        System.out.println("Statistics for the specified Entity ID not found. Please check the Entity ID.");
                                    }
                                default:
                                    continue;
                            }
                        case 5:
                            System.out.println("Transfer Management:");
                            System.out.println("1. Add Transfer");
                            System.out.println("2. View All Transfers");
                            entityId = scanner.nextInt();
                            switch (entityId) {
                                case 1:
                                    System.out.print("Enter Player Name: ");
                                    playerName = scanner.next();
                                    System.out.print("Enter Player ID: ");
                                    playerID = scanner.nextInt();
                                    System.out.print("Enter Age: ");
                                    age = scanner.nextInt();
                                    System.out.print("Enter Nationality: ");
                                    nationality = scanner.next();
                                    System.out.print("Enter Position: ");
                                    String position = scanner.next();
                                    System.out.print("Enter From Team ID: ");
                                    fromTeamID = scanner.nextInt();
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
                                        transferController.addTransfer(playerID, fromTeam, toTeam, transferFee);
                                        System.out.println("Transfer added successfully.");
                                    } else {
                                        System.out.println("The specified Team ID does not exist. Please check the Team ID.");
                                    }
                                    continue;
                                case 2:
                                    List<Transfers> transfers = transferController.getAllTransfers();
                                    Iterator var26 = transfers.iterator();

                                    while(var26.hasNext()) {
                                        Transfers transfer = (Transfers)var26.next();
                                        var10000 = System.out;
                                        var10001 = transfer.getPlayerID();
                                        var10000.println("Player: " + var10001 + ", From Team: " + transfer.getFromTeam().getName() + ", To Team: " + transfer.getToTeam().getName() + ", Transfer Fee: " + transfer.getTransferFee());
                                    }
                                default:
                                    continue;
                            }
                        case 6:
                            System.out.println("Exiting the program.");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            }
        }
    }
}
