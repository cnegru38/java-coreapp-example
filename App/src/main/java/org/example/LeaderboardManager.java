package org.example;

import java.util.*;

class LeaderboardManager {
    private List<Team> teams;

    public LeaderboardManager(List<Team> teams) {
        this.teams = teams;
    }

    public Team getOrCreateTeam(String teamName) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        // Create a new team if not found
        Team newTeam = new Team(teamName);
        teams.add(newTeam);
        return newTeam;
    }

    public int getTeamRank(Team team) {
        sortTeams(); // Ensure teams are sorted
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equalsIgnoreCase(team.getName())) {
                return i + 1; // Rank starts from 1
            }
        }
        return -1; // If not found
    }

    public Team getTeamByName(String teamName) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null; // Return null if team not found
    }

    public void sortTeams() {
        teams.sort((t1, t2) -> {
            if (t2.getTotalPoints() != t1.getTotalPoints()) {
                return Integer.compare(t2.getTotalPoints(), t1.getTotalPoints());
            }
            return Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
        });
    }

    public void displayLeaderboard() {
        int rank = 1;
        for (Team team : teams) {
            System.out.printf("%-5d %-15s %-10s%n",
                    rank++, team.getName(),
                    team.getTotalPoints() + " (" + team.getGoalsScored() + " - " + team.getGoalsConceded() + ")");
        }
    }
}
