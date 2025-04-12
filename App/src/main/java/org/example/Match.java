package org.example;

class Match {
    private int matchID;
    private String team1;
    private String team2;
    private int score1;
    private int score2;
    private boolean isFinished;

    public Match(int matchID, String team1, String team2, int score1, int score2, boolean isFinished) {
        this.matchID = matchID;
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.isFinished = isFinished;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getPointsTeam1() {
        if (!isFinished) return 0;
        if (score1 > score2) return 3;
        if (score1 == score2) return 1;
        return 0;
    }

    public int getPointsTeam2() {
        if (!isFinished) return 0;
        if (score2 > score1) return 3;
        if (score1 == score2) return 1;
        return 0;
    }
}

