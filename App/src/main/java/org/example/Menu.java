package org.example;

import java.util.Scanner;

class Menu {
    private Leaderboard leaderboard;
    private Scanner scanner;

    public Menu(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n===== Leaderboard Menu =====");
            System.out.println("1. Display Full Leaderboard");
            System.out.println("2. Search for a Team");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    leaderboard.displayLeaderboard();
                    break;
                case 2:
                    searchForTeam();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchForTeam() {
        System.out.print("\nEnter team name: ");
        String teamName = scanner.nextLine();
        Team team = leaderboard.getManager().getTeamByName(teamName);

        if (team != null) {
            // Get sorted teams to determine rank
            leaderboard.getManager().sortTeams();
            int rank = leaderboard.getManager().getTeamRank(team);

            // Display team details
            System.out.printf("%-5d %-15s %-10s %-10d%n",
                    rank, team.getName(),
                    team.getTotalPoints() + " (" + team.getGoalsScored() + " - " + team.getGoalsConceded() + ")",
                    team.getGoalDifference());
        } else {
            System.out.println("Team not found.");
        }
    }
}
