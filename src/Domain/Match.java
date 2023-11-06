package Domain;

import java.util.Date;

public class Match {
    private int matchID;
    private Team homeTeamID;
    private Team awayTeamID;
    private Date matchDate;
    private String location;

    private int scoreHomeTeam;
    private int scoreAwayTeam;

    private int refereeID;
    private int competitionID;

    public Match(int matchID, Team homeTeamID, Team awayTeamID, Date matchDate, String location, int scoreHomeTeam, int scoreAwayTeam, int refereeID, int competitionID) {
        this.matchID = matchID;
        this.homeTeamID = homeTeamID;
        this.awayTeamID = awayTeamID;
        this.matchDate = matchDate;
        this.location = location;
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreAwayTeam = scoreAwayTeam;
        this.refereeID=refereeID;
        this.competitionID=competitionID;
    }

    public Team getHomeTeamID() {
        return homeTeamID;
    }

    public Team getAwayTeamID() {
        return awayTeamID;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public String getLocation() {
        return location;
    }

    //SETTERS
    public void setHomeTeam(Team homeTeam) {
        this.homeTeamID = homeTeamID;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeamID = awayTeamID;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setScoreHomeTeam(int scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
    }

    public void setScoreAwayTeam(int scoreAwayTeam) {
        this.scoreAwayTeam = scoreAwayTeam;
    }

    public int getMatchID() {
        return getMatchID();
    }
}