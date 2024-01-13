package com.laborator.FootballDatabase.Domain;
import javax.persistence.*;
@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    private int entityId;
    private int goalsScored;
    private int goalsConceded;
    private int wins;
    private int draws;
    private int losses;

    public Statistics(int entityId,int goalsScored,int goalsConceded,int wins,int draws,int losses) {
        this.entityId = entityId;
        this.goalsScored = 0;
        this.goalsConceded = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public int getEntityId() {
        return entityId;
    }
    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

}