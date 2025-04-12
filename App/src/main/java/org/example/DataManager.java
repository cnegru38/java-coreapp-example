package org.example;

import java.io.*;
import java.util.*;

class DataManager {
    public static List<Team> readTeamsFromFile(String filePath) {
        List<Team> teams = new ArrayList<>();
        Map<String, Team> teamMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Read team name
                String teamName = line.trim();
                if (teamName.isEmpty()) continue;

                Team team = new Team(teamName);
                teamMap.put(teamName, team);

                // Read match details until total points are encountered
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String[] parts = line.split(" ");

                    // If the first element is a number but only one number (total points), break
                    if (parts.length == 1 && parts[0].matches("\\d+")) {
                        break; // Move to reading total points
                    }

                    if (parts.length == 6) {
                        int matchID = Integer.parseInt(parts[0]);
                        String team1 = parts[1];
                        String team2 = parts[2];
                        int score1 = Integer.parseInt(parts[3]);
                        int score2 = Integer.parseInt(parts[4]);
                        boolean isFinished = parts[5].equals("1");

                        Match match = new Match(matchID, team1, team2, score1, score2, isFinished);
                        team.addMatch(match);
                    }
                }

                // Read total points, goals scored, and goals conceded
                int totalPoints = Integer.parseInt(line.trim());
                int goalsScored = Integer.parseInt(br.readLine().trim());
                int goalsConceded = Integer.parseInt(br.readLine().trim());

                // Update team stats
                team.addTotalPoints(totalPoints);
                team.addGoalsScored(goalsScored);
                team.addGoalsConceded(goalsConceded);

                teams.add(team);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return teams;
    }
}
