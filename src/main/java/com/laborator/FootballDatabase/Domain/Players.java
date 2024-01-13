package com.laborator.FootballDatabase.Domain;
import com.laborator.FootballDatabase.StrategyPattern.*;
import javax.persistence.*;

@Entity
@Table(name = "players")
public class Players {
    @Id
    private int age;
    private AgeCategoryStrategy ageCategoryStrategy;

    public void setAgeCategoryStrategy() {
        if (age < 20 && age > 16) {
            ageCategoryStrategy = new YoungPlayerStrategy();
        } else if (age >= 20 && age < 30) {
            ageCategoryStrategy = new MiddlePlayerStrategy();
        } else if (age > 30){
            ageCategoryStrategy = new OldPlayerStrategy();
        }
    }

    public String getAgeCategory() {
        if (ageCategoryStrategy == null) {
            return "Unknown";
        }
        return ageCategoryStrategy.getCategory(age);
    }

    private int playerID;
    private String nationality;
    private String position;
    private int teamID;
    private String name;
    private int number;

    public Players(int playerID, String name, int age, String nationality, String position, int teamID, int number) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        setAgeCategoryStrategy();
        this.nationality = nationality;
        this.position = position;
        this.teamID = teamID;
        this.number = number;
    }

    public int getPlayerID(){
        return playerID;
    }
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getNationality(){
        return nationality;
    }
    public String getPosition(){
        return position;
    }
    public int getTeamID(){
        return teamID;
    }
    public int getNumber() {
        return number;
    }

    public void setPlayerID(int playerId) {
        this.playerID = playerId;
    }
}