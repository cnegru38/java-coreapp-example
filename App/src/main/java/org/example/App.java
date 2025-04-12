package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();

        // Universal file path relative to project directory
        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "org", "example", "teams.txt");
        leaderboard.loadTeamsFromFile(filePath.toString());

        // Run the menu
        Menu menu = new Menu(leaderboard);
        menu.displayMenu();
    }
}

