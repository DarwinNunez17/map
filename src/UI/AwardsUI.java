package UI;

import Domain.Awards;
import Repository.AwardsRepository;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AwardsUI {
    private static final String URL = "jdbc:mysql://localhost:3306/football";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    public static void ui(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/football", "root", "123456");

            try {
                Scanner scanner = new Scanner(System.in);

                try {
                    AwardsRepository awardsRepository = new AwardsRepository(connection);
                    boolean running = true;

                    label67:
                    while(true) {
                        label65:
                        while(true) {
                            if (!running) {
                                break label67;
                            }

                            System.out.println("1. Add Award");
                            System.out.println("2. Get Award by Name");
                            System.out.println("3. Get All Awards");
                            System.out.println("4. Update Award");
                            System.out.println("5. Delete Award");
                            System.out.println("6. Exit");
                            System.out.print("Enter your choice: ");
                            int choice = scanner.nextInt();
                            PrintStream var10000;
                            String var10001;
                            switch (choice) {
                                case 1:
                                    System.out.print("Enter award name: ");
                                    scanner.nextLine();
                                    String name = scanner.nextLine();
                                    System.out.print("Enter award year: ");
                                    int year = scanner.nextInt();
                                    awardsRepository.addAward(new Awards(name, year));
                                    System.out.println("Award added!");
                                    break;
                                case 2:
                                    System.out.print("Enter award name: ");
                                    scanner.nextLine();
                                    String awardName = scanner.nextLine();
                                    Awards award = awardsRepository.getAwardByName(awardName);
                                    if (award != null) {
                                        var10000 = System.out;
                                        var10001 = award.getName();
                                        var10000.println("Award found: " + var10001 + ", Year: " + award.getYear());
                                    } else {
                                        System.out.println("Award not found!");
                                    }
                                    break;
                                case 3:
                                    List<Awards> allAwards = awardsRepository.getAllAwards();
                                    Iterator var19 = allAwards.iterator();

                                    while(true) {
                                        if (!var19.hasNext()) {
                                            continue label65;
                                        }

                                        Awards a = (Awards)var19.next();
                                        var10000 = System.out;
                                        var10001 = a.getName();
                                        var10000.println("Name: " + var10001 + ", Year: " + a.getYear());
                                    }
                                case 4:
                                    System.out.print("Enter award name to update: ");
                                    scanner.nextLine();
                                    String oldName = scanner.nextLine();
                                    System.out.print("Enter new year: ");
                                    int newYear = scanner.nextInt();
                                    awardsRepository.updateAward(new Awards(oldName, newYear));
                                    System.out.println("Award updated!");
                                    break;
                                case 5:
                                    System.out.print("Enter award name to delete: ");
                                    scanner.nextLine();
                                    String awardToDelete = scanner.nextLine();
                                    awardsRepository.deleteAward(awardToDelete);
                                    System.out.println("Award deleted!");
                                    break;
                                case 6:
                                    running = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                            }
                        }
                    }
                } catch (Throwable var16) {
                    try {
                        scanner.close();
                    } catch (Throwable var15) {
                        var16.addSuppressed(var15);
                    }

                    throw var16;
                }

                scanner.close();
            } catch (Throwable var17) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var14) {
                        var17.addSuppressed(var14);
                    }
                }

                throw var17;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var18) {
            var18.printStackTrace();
        }

    }
}
