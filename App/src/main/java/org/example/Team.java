package org.example;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String name;
    private List<Match> matches;
    private int totalPoints;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name) {
        this.name = name;
        this.matches = new ArrayList<>();
        this.totalPoints = 0;
        this.goalsScored = 0;
        this.goalsConceded = 0;
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference() {
        return goalsScored - goalsConceded;
    }

    public void addMatch(Match match) {
        matches.add(match);
        if (match.getTeam1().equals(this.name)) {
            updateStats(match.getScore1(), match.getScore2(), calculatePoints(match.getScore1(), match.getScore2()));
        } else if (match.getTeam2().equals(this.name)) {
            updateStats(match.getScore2(), match.getScore1(), calculatePoints(match.getScore2(), match.getScore1()));
        }
    }

    private void updateStats(int scored, int conceded, int points) {
        this.goalsScored += scored;
        this.goalsConceded += conceded;
        this.totalPoints += points;
    }

    private int calculatePoints(int score1, int score2) {
        if (score1 > score2) return 5;  // Winning team gets 5 points
        if (score1 == score2) return 2; // Draw results in 2 points
        return 0; // Losing team gets 0 points
    }

    public void addTotalPoints(int points) {
        this.totalPoints = points;
    }

    public void addGoalsScored(int goals) {
        this.goalsScored = goals;
    }

    public void addGoalsConceded(int goals) {
        this.goalsConceded = goals;
    }
}