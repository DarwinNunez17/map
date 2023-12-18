package UI;
import Domain.Competitions;
import Repository.CompetitionsRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CompetitionsUI {
    private static final String URL = "jdbc:mysql://localhost:3306/football";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public CompetitionsUI() {
    }

    public static void ui(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "123456");

            try {
                Scanner scanner = new Scanner(System.in);

                try {
                    CompetitionsRepository competitionsRepository = new CompetitionsRepository(connection);
                    boolean running = true;

                    while(running) {
                        System.out.println("1. Add Competition");
                        System.out.println("2. Get Competition by Name");
                        System.out.println("3. Get All Competitions");
                        System.out.println("5. Delete Competition");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                addCompetition(scanner, competitionsRepository);
                                break;
                            case 2:
                                getCompetitionByName(scanner, competitionsRepository);
                                break;
                            case 3:
                                getAllCompetitions(competitionsRepository);
                                break;
                            case 4:
                            default:
                                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                                break;
                            case 5:
                                deleteCompetition(scanner, competitionsRepository);
                                break;
                            case 6:
                                running = false;
                        }
                    }
                } catch (Throwable var8) {
                    try {
                        scanner.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }

                    throw var8;
                }

                scanner.close();
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

    }

    private static void addCompetition(Scanner scanner, CompetitionsRepository competitionsRepository) {
        System.out.print("Enter competition name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        competitionsRepository.addCompetition(new Competitions(name));
        System.out.println("Competition added!");
    }

    private static void getCompetitionByName(Scanner scanner, CompetitionsRepository competitionsRepository) {
        System.out.print("Enter competition name: ");
        scanner.nextLine();
        String competitionName = scanner.nextLine();
        Competitions competition = competitionsRepository.getCompetitionByName(competitionName);
        if (competition != null) {
            System.out.println("Competition found: " + competition.getName());
        } else {
            System.out.println("Competition not found!");
        }

    }

    private static void getAllCompetitions(CompetitionsRepository competitionsRepository) {
        List<Competitions> allCompetitions = competitionsRepository.getAllCompetitions();
        Iterator var2 = allCompetitions.iterator();

        while(var2.hasNext()) {
            Competitions competition = (Competitions)var2.next();
            System.out.println("Name: " + competition.getName());
        }

    }

    private static void deleteCompetition(Scanner scanner, CompetitionsRepository competitionsRepository) {
        System.out.print("Enter competition name to delete: ");
        scanner.nextLine();
        String competitionToDelete = scanner.nextLine();
        competitionsRepository.deleteCompetition(competitionToDelete);
        System.out.println("Competition deleted!");
    }
}
