package org.example;

import java.util.*;

class Leaderboard {
    private List<Team> teams;
    private LeaderboardManager manager;

    public Leaderboard() {
        this.teams = new ArrayList<>();
        this.manager = new LeaderboardManager(teams);
    }

    public void loadTeamsFromFile(String filePath) {
        this.teams = DataManager.readTeamsFromFile(filePath);
        this.manager = new LeaderboardManager(teams);
    }

    public void displayLeaderboard() {
        manager.sortTeams();
        manager.displayLeaderboard();
    }

    public LeaderboardManager getManager() {
        return manager;
    }
}
