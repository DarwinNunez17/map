package com.laborator.FootballDatabase.Domain;

import javax.persistence.*;
// Component interface
interface ManagerComponent {
    int getManagerID();

    String getName();

    String getNationality();

    int getTeamID();
}

@Entity
@Table(name = "managers")
public class Manager implements ManagerComponent {
    @Id
    private int managerID;
    private String name;
    private String nationality;
    private int teamID;

    public Manager(int managerID, String name, String nationality, int teamID) {
        this.managerID = managerID;
        this.name = name;
        this.nationality = nationality;
        this.teamID = teamID;
    }

    @Override
    public int getManagerID() {
        return managerID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public int getTeamID() {
        return teamID;
    }

    public void setManagerID(int managerId) {
        this.managerID=managerId;
    }
}

// Decorator class
class ManagerDecorator implements ManagerComponent {
    private final ManagerComponent decoratedManager;

    public ManagerDecorator(ManagerComponent decoratedManager) {
        this.decoratedManager = decoratedManager;
    }

    @Override
    public int getManagerID() {
        // Additional behavior, e.g., logging
        System.out.println("Getting Manager ID");
        return decoratedManager.getManagerID();
    }

    @Override
    public String getName() {
        // Additional behavior, e.g., logging
        System.out.println("Getting Manager Name");
        return decoratedManager.getName();
    }

    @Override
    public String getNationality() {
        // Additional behavior, e.g., logging
        System.out.println("Getting Manager Nationality");
        return decoratedManager.getNationality();
    }

    @Override
    public int getTeamID() {
        // Additional behavior, e.g., logging
        System.out.println("Getting Manager Team ID");
        return decoratedManager.getTeamID();
    }
}
